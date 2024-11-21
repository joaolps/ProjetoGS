from flask import Flask, jsonify
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression
from sklearn.metrics import mean_squared_error, r2_score
import pandas as pd

# Inicialização do Flask
app = Flask(__name__)

# Leitura do dataset
df = pd.read_csv('transicao_energetica_brasil.csv')

# Função para treinar o modelo e retornar os resultados
def buscarDados():
    # Seleção das variáveis (features) e da variável alvo (target)
    X = df[["Produção de Energia (MWh)", "Consumo Residencial (MWh)", 
            "Consumo Industrial (MWh)", "Percentual de Veículos Elétricos (%)"]]
    y = df["Redução de Emissões de CO₂ (Milhões de Toneladas)"]

    # Divisão dos dados em conjuntos de treino e teste
    X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

    # Criação e treinamento do modelo de regressão
    reg_model = LinearRegression()
    reg_model.fit(X_train, y_train)

    # Previsões e avaliação do modelo
    y_pred = reg_model.predict(X_test)
    mse = mean_squared_error(y_test, y_pred)
    r2 = r2_score(y_test, y_pred)

    # Retorna os coeficientes do modelo, o intercepto, MSE e o R²
    return reg_model.coef_, reg_model.intercept_, mse, r2

# Endpoint GET para retornar os dados do modelo
@app.route('/dados_modelo', methods=['GET'])
def get_dados_modelo():
    coeficientes, intercepto, mse, r2 = buscarDados()

    # Retorna os dados em formato JSON
    return jsonify({
        'coeficientes': coeficientes.tolist(),
        'intercepto': intercepto,
        'erro_quadratico_medio': mse,
        'r2': r2
    })

# Executa o servidor Flask
if __name__ == '__main__':
    app.run(debug=True)

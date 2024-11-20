from flask import Flask, request, jsonify
import pickle
import pandas as pd

# Inicialização da aplicação Flask
app = Flask(__name__)

# Carregar modelos preditivos previamente treinados
model_paths = {
    'regression': 'models/regression_model.pkl',
    'classification': 'models/classification_model.pkl',
    'clustering': 'models/clustering_model.pkl'
}

models = {}
for model_type, path in model_paths.items():
    try:
        with open(path, 'rb') as f:
            models[model_type] = pickle.load(f)
    except FileNotFoundError:
        print(f"Modelo {model_type} não encontrado em {path}.")

@app.route('/')
def home():
    return "API de Modelos Preditivos Integrados!"

@app.route('/predict/<model_type>', methods=['POST'])
def predict(model_type):
    if model_type not in models:
        return jsonify({"error": f"Modelo '{model_type}' não está disponível."}), 404

    model = models[model_type]
    try:
        # Receber os dados em formato JSON
        data = request.get_json()
        df = pd.DataFrame(data)

        # Fazer previsões com base no modelo
        if model_type == 'clustering':
            predictions = model.predict(df)
        else:
            predictions = model.predict(df.values)

        return jsonify({"predictions": predictions.tolist()})
    except Exception as e:
        return jsonify({"error": str(e)}), 500

if __name__ == '__main__':
    app.run(debug=True)

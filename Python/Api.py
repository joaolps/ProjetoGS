import Crud_Banco
import json
from Banco import conectar_db
from ErrorBanco import ErroBanco
from flask import Flask, request, jsonify


app =  Flask(__name__)
conn = conectar_db()

def salvar_json_em_json(dados):
    with open("itens.json", "w", encoding="utf-8") as arquivo:
        json.dump(dados, arquivo, ensure_ascii=False, indent=4)

@app.route("/inserir", methods=["POST"])
def inserir_registros():
    dados = request.json
    try:
        if "nome" not in dados or "idade" not in dados:
            return {"Erro": "campos nome e idade devem ser preenchidos."}, 400
        user = Crud_Banco.inserir_registro_api(conn, dados["nome"], dados["idade"])
        return jsonify(user), 201 
    except ErroBanco as erro:
        return {"error": str(erro)}, 500
 
if __name__ == "__main__":
    app.run(debug=True)
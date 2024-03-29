<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>
        Cadastro de Requisitante - HealthTech
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="styles.css" type="text/css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>


<c:if test="${not empty mensagem}">
    <div class="alert alert-success" id="mensagem">
            ${mensagem}
    </div>
    <style>

        #mensagem {
            display: flex;
            justify-content: center;
            float:top;
        }
    </style>
    <script defer>
        setTimeout(function() {
            $("#mensagem").fadeOut(5000);
        }, 2500);
    </script>
</c:if>

<c:import url="../menu.jsp" />

    <div class="container">
        <h1>Cadastro de acessorios</h1>
        <form action="cadastroEquipamento/incluir" method="post">

            <c:import url="../PaginasProduto/cadastroProduto.jsp" />
            <div class="form-group">
                <label for="anoFabricacao">Ano de fabricação:</label>
                <input type="number" class="form-control" id="anoFabricacao" name="anoFabricacao" placeholder="Insira o ano de fabricação do equipamento" required>
            </div>

            <div class="form-group">
                <label for="numeroSerie">Número de série:</label>
                <input type="text" class="form-control" id="numeroSerie" name="numeroSerie" placeholder="Insira o número de série do equipamento" required>
            </div>

            <div id="tensao">
                <span>Tensão do equipamento</span>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="tensao" value="0" id="flexRadioDefault1" >
                    <label class="form-check-label" for="flexRadioDefault1">
                        127V
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="tensao" id="flexRadioDefault2" value="1" checked >
                    <label class="form-check-label" for="flexRadioDefault2">
                        220V(bifásico)
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="tensao"  value="2"  >
                    <label class="form-check-label" for="flexRadioDefault2">
                        220V(trifásico)
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="tensao"  value="3"  >
                    <label class="form-check-label" for="flexRadioDefault2">
                        12V
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="tensao" value="4"  >
                    <label class="form-check-label" for="flexRadioDefault2">
                        24V
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="tensao"  value="5"  >
                    <label class="form-check-label" for="flexRadioDefault2">
                        48V
                    </label>
                </div>

                <div id="corrente">
                    <span>Corrente do equipamento: </span>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="corrente" value="0" checked >
                        <label class="form-check-label" for="flexRadioDefault1">
                            250mA
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="corrente" value="1" >
                        <label class="form-check-label" for="flexRadioDefault2">
                            500mA
                        </label>
                    </div>

                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="corrente" value="2" >
                        <label class="form-check-label" for="flexRadioDefault2">
                            1A
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="corrente" value="3" >
                        <label class="form-check-label" for="flexRadioDefault2">
                            2A
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="corrente" value="3" >
                        <label class="form-check-label" for="flexRadioDefault2">
                            5A
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="corrente" value="3" >
                        <label class="form-check-label" for="flexRadioDefault2">
                            10A
                        </label>
                    </div>
                </div>
                </div>

            <div id="estado">
                <span>Estado do equipamento: </span>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="estado" value="usado" checked >
                    <label class="form-check-label" for="flexRadioDefault1">
                        Usado
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="estado" value="novo" checked >
                    <label class="form-check-label" for="flexRadioDefault1">
                        Novo
                    </label>
                </div>
            </div>


            <button type="submit" class="btn btn-primary">Cadastrar</button>
            <button class="btn btn-danger" onclick="limparCampos()">Limpar</button>
        </form>
    </div>


<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js"></script>
</body>

</body>
</html>
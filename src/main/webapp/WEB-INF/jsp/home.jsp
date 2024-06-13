<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Padaria</title>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<div class="container-fluid">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link active" href="/">Padaria</a></li>
				<li class="nav-item"><a class="nav-link" href="/padeiro/listagem">Padeiros</a></li>
				<li class="nav-item"><a class="nav-link" href="/produto/listagem">Produtos</a></li>
				<li class="nav-item"><a class="nav-link" href="/doce/listagem">Doces</a></li>
				<li class="nav-item"><a class="nav-link" href="/pao/listagem">Paes</a></li>
			</ul>
		</div>
	</nav>

	<div class="container mt-3">

		<span class="badge rounded-pill bg-primary">Padeiro:
			${qtdePadeiro}</span> <span class="badge rounded-pill bg-secondary">Produto:
			${qtdeProduto}</span> <span class="badge rounded-pill bg-success">Doce:
			${qtdeDoce}</span> <span class="badge rounded-pill bg-danger">Pao:
			${qtdePao}</span>

		<c:if test="${not empty listagem}">
			<h2>Padaria</h2>
			<p>Gestao de vendas de produtos:</p>
			<table class="table">
				<thead class="table-dark">
					<tr>
						<th>${titulo}</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${listagem}">
						<tr>
							<td>${item}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>

		<c:if test="${empty listagem}">
			<div class="container mt-5">
		        <div class="card mx-auto" style="width: 18rem;">
		            <img src="https://media.licdn.com/dms/image/D4D03AQGiQp_Zz-L0UA/profile-displayphoto-shrink_800_800/0/1705692855864?e=1723680000&v=beta&t=QKv_fsNpDhztJbFxjn1ouoa7APZAT4psY44Sd4YJyVA" class="card-img-top" alt="Foto do Desenvolvedor">
		            <div class="card-body">
		                <h5 class="card-title">Luiz Henrique</h5>
		                <p class="card-text"><strong>Telefone:</strong> (21) 97915-0350</p>
		                <p class="card-text">Atuo como profissional de TI desde o dia primeiro de abril de dois mil e tres.</p>
		                <a href="https://github.com/LuizHasDevops/padaria" class="btn btn-primary">GitHub do Projeto</a>
		                <a href="https://www.linkedin.com/in/luiz-henrique-de-souza/" class="btn btn-secondary">LinkedIn</a>
		            </div>
		        </div>
		    </div>
	    </c:if>

	</div>
    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/js/bootstrap.min.js"></script>
</body>
</html>
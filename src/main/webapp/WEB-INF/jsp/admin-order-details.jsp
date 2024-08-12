<jsp:include page="include/admin-header.jsp" />



<h1>This is the Admin Order Details</h1>

<h2>${message}</h2>


<table class="table">

    <tr><td>id</td><td>${productKey.id}</td></tr>

    <tr><td>code</td><td>${productKey.productCode}</td></tr>

    <tr><td>name</td><td>${productKey.productName}</td></tr>

    <tr><td>description</td><td>${productKey.productDescription}</td></tr>

</table>



<jsp:include page="include/footer.jsp" />
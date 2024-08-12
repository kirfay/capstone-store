<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<!-- Page Header -->
<section style="background-color: #212529; color: white; padding: 1rem 0;"> <!-- Consistent with other pages -->
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">This is an Admin JSP Page</h1>
        </div>
    </div>
</section>

<!-- Products List -->
<section style="background-color: #f8f9fa;"> <!-- Light background for content section -->
    <div class="container">
        <div class="row pt-5">
            <div class="col-12">
                <h2 class="text-center">All Products (${products.size()})</h2>
            </div>
        </div>
        <div class="row pt-3">
            <div class="col-12">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Image</th>
                        <th>Description</th>
                        <th>Edit</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${products}" var="product">
                        <tr>
                            <td><a href="/?id=${product.id}" class="text-dark">${product.id}</a></td> <!-- Consistent text color -->
                            <td>${product.name}</td>
                            <td>${product.price}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${empty product.imageUrl}">
                                        <p>No image available</p>
                                    </c:when>
                                    <c:otherwise>
                                        <img src="${product.imageUrl}" alt="Product Image" style="border: 2px solid #212529; border-radius: 5px; margin-top: 20px; width: 100px; height: auto;"> <!-- Consistent border color -->
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>${product.description}</td>
                            <td><a href="/product/detail?productId=${product.id}" class="text-primary">Edit</a></td> <!-- Consistent link color -->
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />
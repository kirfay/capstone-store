<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="include/header.jsp" />

<!-- Page Header -->
<section style="background-color: #212529; color: white; padding: 1rem 0;"> <!-- Consistent with Login and Create Account pages -->
    <div class="container">
        <div class="row ">
            <h1 class="text-center">Search Page</h1>
        </div>
    </div>
</section>

<!-- Search Form -->
<section style="background-color: Teal; min-height: calc(100vh - 56px); display: flex; align-items: center;"> <!-- Consistent with Login and Create Account pages -->
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-8 text-center" style="margin-top: -150px;">
                <form action="/search">
                    <div class="mb-3">
                        <label for="search" class="form-label text-white"><h4>Product Name Search</h4></label> <!-- Text color white -->
                        <input type="text" value="${search}" class="form-control" id="search" name="search" placeholder="Enter search term"/>
                    </div>
                    <button type="submit" class="btn btn-primary">Search</button>
                </form>
            </div>
        </div>
    </div>
</section>

<!-- Products Found -->
<section style="background-color: #f8f9fa;"> <!-- Light background for content section -->
    <div class="container">
        <div class="row pt-5">
            <div class="col-12">
                <h2 class="text-center">Products Found (${products.size()})</h2>
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
                        <th>Add to cart</th>


                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${products}" var="product">
                        <tr>
                            <td><a href="/?id=${product.id}" class="text-dark">${product.id}</a></td> <!-- Consistent text color -->
                            <td>${product.name}</td>
                            <td>${product.price}</td>
                            <td><a href="/?id=${product.id}">Edit</a></td>
                            <td><a href="/order/addToCart?id=${product.id}">Add To Cart</a></td>
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

<jsp:include page="include/footer.jsp" />
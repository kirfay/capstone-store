<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<h1 class="page-title">This is a product detail page</h1>

<section>
    <div class="row pt-5">
        <div class="col-12">
            <h2 class="text-center">Product ${product.id} ${product.name}</h2>
        </div>
    </div>
    <div class="row justify-content-center">
        <table class="table table-success table-striped table-bordered table-responsive" style="width: 750pt">
            <tr>
                <td style="font-weight: bolder;">Product ID:</td>
                <td>${product.id}</td>
            </tr>
            <tr>
                <td style="font-weight: bolder;">Product Name:</td>
                <td>${product.name}</td>
            </tr>
            <tr>
                <td style="font-weight: bolder;">Product Price:</td>
                <td>${product.price}</td>
            </tr>

            <tr>
                <td>Image</td>
                <!-- /pub/images/...jpg -->
                <td><img src="${product.imageUrl}"/></td>
            </tr>
            <tr>
                <td style="font-weight: bolder;">Product Description:</td>
                <td>${product.description}</td>
            </tr>


        </table>
    </div>

    <div class="row justify-content-center">
        <div class="col-auto">
            <a href="/product/edit?productId=${product.id}">Edit</a>
        </div>
    </div>
</section>
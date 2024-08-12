<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<!-- Page Header -->
<section style="background-color: Teal; color: white; padding: 1rem 0;">
    <div class="container">
        <div class="row pt-5 pb-5">
            <c:if test="${empty form.productId}">
                <h1 class="text-center">Create Product</h1>
            </c:if>
            <c:if test="${not empty form.productId}">
                <h1 class="text-center">Edit Product</h1>
            </c:if>
        </div>
    </div>
</section>

<c:if test="${not empty errorMessage}">
    <section style="background-color: Teal; color: white; padding: 1rem 0;">
        <div class="container">
            <div class="row justify-content-center mb-4">
                <div class="col-md-8 col-lg-6">
                    <div class="alert alert-danger" role="alert">${errorMessage}</div>
                </div>
            </div>
        </div>
    </section>
</c:if>

<section style="background-color: Teal; min-height: calc(100vh - 56px); display: flex; align-items: center; padding: 2rem 0;"> <!-- Added padding -->
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-8 col-lg-6">
                <div class="card border-light shadow-sm" style="background-color: #ffffff; color: #212529;">
                    <div class="card-body">
                        <form action="/product/createSubmit" method="post">
                            <input type="hidden" name="productId" value="${form.productId}">

                            <!-- Product Name input field -->
                            <div class="mb-3">
                                <label for="name" class="form-label">Product Name</label>
                                <input type="text" id="name" name="productName" class="form-control <c:if test="${bindingResult.hasFieldErrors('productName')}">is-invalid</c:if>" value="${form.productName}">
                                <c:if test="${bindingResult.hasFieldErrors('productName')}">
                                    <div class="invalid-feedback">
                                        <c:forEach items="${bindingResult.getFieldErrors('productName')}" var="error">
                                            ${error.defaultMessage}<br>
                                        </c:forEach>
                                    </div>
                                </c:if>
                            </div>

                            <!-- Product Price input field -->
                            <div class="mb-3">
                                <label for="priceId" class="form-label">Price</label>
                                <input type="number" id="priceId" name="productPrice" class="form-control <c:if test="${bindingResult.hasFieldErrors('productPrice')}">is-invalid</c:if>" value="${form.productPrice}">
                                <c:if test="${bindingResult.hasFieldErrors('productPrice')}">
                                    <div class="invalid-feedback">
                                        <c:forEach items="${bindingResult.getFieldErrors('productPrice')}" var="error">
                                            ${error.defaultMessage}<br>
                                        </c:forEach>
                                    </div>
                                </c:if>
                            </div>

                            <!-- Product Image URL input field -->
                            <div class="mb-3">
                                <label for="imageUrl" class="form-label">Image URL</label>
                                <input type="text" id="imageUrl" name="productImageUrl" class="form-control <c:if test="${bindingResult.hasFieldErrors('productImageUrl')}">is-invalid</c:if>" value="${form.productImageUrl}">
                                <c:if test="${bindingResult.hasFieldErrors('productImageUrl')}">
                                    <div class="invalid-feedback">
                                        <c:forEach items="${bindingResult.getFieldErrors('productImageUrl')}" var="error">
                                            ${error.defaultMessage}<br>
                                        </c:forEach>
                                    </div>
                                </c:if>
                            </div>

                            <!-- Product Description input field -->
                            <div class="mb-3">
                                <label for="description" class="form-label">Description</label>
                                <input type="text" id="description" name="productDescription" class="form-control <c:if test="${bindingResult.hasFieldErrors('productDescription')}">is-invalid</c:if>" value="${form.productDescription}">
                                <c:if test="${bindingResult.hasFieldErrors('productDescription')}">
                                    <div class="invalid-feedback">
                                        <c:forEach items="${bindingResult.getFieldErrors('productDescription')}" var="error">
                                            ${error.defaultMessage}<br>
                                        </c:forEach>
                                    </div>
                                </c:if>
                            </div>

                            <!-- Cosmetic Fields -->
                            <!-- Radio Button options -->
                            <div class="mb-3">
                                <label class="form-label">Options</label>
                                <div>
                                    <input type="radio" id="option1" name="options" value="option1">
                                    <label for="option1">Radio button</label>
                                </div>
                            </div>

                            <!-- Checkbox options -->
                            <div class="mb-3">
                                <label class="form-label">Checkbox</label>
                                <div>
                                    <input type="checkbox" id="feature1" name="features" value="feature1">
                                    <label for="feature1">Take This Product home</label>
                                </div>
                                <div>
                                    <input type="checkbox" id="feature2" name="features" value="feature2">
                                    <label for="feature2">You Need This Product</label>
                                </div>
                                <div>
                                    <input type="checkbox" id="feature3" name="features" value="feature3">
                                    <label for="feature3">You Really Want This Product</label>
                                </div>
                            </div>

                            <!-- Select menu -->
                            <div class="mb-3">
                                <label for="selectMenu" class="form-label">Select</label>
                                <select id="selectMenu" name="category" class="form-control">
                                    <option value="category1">I made a web application</option>
                                    <option value="category2">in HTML</option>
                                    <option value="category3">for the first time</option>
                                </select>
                            </div>

                            <div class="text-center">
                                <button type="submit" id="my-button" class="btn btn-primary">Submit</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>



<jsp:include page="../include/footer.jsp"/>
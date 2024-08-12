<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<!-- Page Header -->
<section style="background-color: #212529; color: white; padding: 1rem 0;"> <!-- Consistent with Login page -->
    <div class="container">

        <h1 class="text-center">Create Account</h1>

    </div>
</section>

<!-- Create Account Form -->
<section style="background-color: Teal; min-height: calc(100vh - 56px); display: flex; align-items: center;"> <!-- Consistent with Login page -->
    <div class="container">
        <div class="row justify-content-center mb-4">
            <div class="col-md-8 col-lg-6">
                <div class="card border-light shadow-sm" style="background-color: #ffffff; color: #212529; margin-top: -150px;">
                    <div class="card-body">
                        <form action="/account/create-account" method="post">

                            <!-- Email Input -->
                            <div class="mb-3">
                                <label for="emailId" class="form-label">Email</label>
                                <input type="text" id="emailId" name="email" class="form-control <c:if test="${bindingResult.hasFieldErrors('email')}">is-invalid</c:if>" value="${form.email}">
                                <c:if test="${bindingResult.hasFieldErrors('email')}">
                                    <div class="invalid-feedback">
                                        <c:forEach items="${bindingResult.getFieldErrors('email')}" var="error">
                                            ${error.defaultMessage}<br>
                                        </c:forEach>
                                    </div>
                                </c:if>
                            </div>

                            <!-- Password Input -->
                            <div class="mb-3">
                                <label for="passwordId" class="form-label">Password</label>
                                <input type="password" id="passwordId" name="password" class="form-control <c:if test="${bindingResult.hasFieldErrors('password')}">is-invalid</c:if>" value="${form.password}">
                                <c:if test="${bindingResult.hasFieldErrors('password')}">
                                    <div class="invalid-feedback">
                                        <c:forEach items="${bindingResult.getFieldErrors('password')}" var="error">
                                            ${error.defaultMessage}<br>
                                        </c:forEach>
                                    </div>
                                </c:if>
                            </div>

                            <div class="text-center">
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />
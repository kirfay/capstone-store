<jsp:include page="include/header.jsp" />

<section id="home" class="hero-section">
    <div class="hero-content">
        <h2>Welcome </h2>
        <p>Find the best products at unbeatable prices.</p>
        <button id="shopNowBtn">Learn About Our Products</button>
    </div>
</section>

<section id="shop" class="shop-section">
    <h2>Featured Products</h2>
    <div class="products">
        <div class="product-card">
            <img src="product1.jpg" alt="Product 1">
            <h3>Product 1</h3>
            <p>$10.00</p>
        </div>
        <div class="product-card">
            <img src="product2.jpg" alt="Product 2">
            <h3>Product 2</h3>
            <p>$200.00</p>
        </div>
        <div class="product-card">
            <img src="product3.jpg" alt="Product 3">
            <h3>Product 3</h3>
            <p>$49.99</p>
        </div>
    </div>
</section>

<section id="about" class="about-section">
    <h2>About Us</h2>
    <p>We are a leading e-commerce site providing you a full range of Amazon seller services. Let us help you turn your 9-5 job into a 24-hr Job! Start selling on Amazon today. </p>
</section>

<section id="contact" class="contact-section">
    <h2>Contact Us</h2>
    <form>
        <input type="text" placeholder="Name" required>
        <input type="email" placeholder="Email" required>
        <textarea placeholder="Message" required></textarea>
        <button type="submit">Send Message</button>
    </form>
</section>


<jsp:include page="include/footer.jsp" />


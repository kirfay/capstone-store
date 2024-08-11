<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>E-Commerce Store</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<header>
    <div class="logo">
        <h1>YourStore</h1>
    </div>
    <nav>
        <ul>
            <li><a href="#home">Home</a></li>
            <li><a href="#shop">Shop</a></li>
            <li><a href="#about">About</a></li>
            <li><a href="#contact">Contact</a></li>
        </ul>
    </nav>
</header>

<section id="home" class="hero-section">
    <div class="hero-content">
        <h2>Welcome to YourStore</h2>
        <p>Find the best products at unbeatable prices.</p>
        <button id="shopNowBtn">Shop Now</button>
    </div>
</section>

<section id="shop" class="shop-section">
    <h2>Featured Products</h2>
    <div class="products">
        <div class="product-card">
            <img src="product1.jpg" alt="Product 1">
            <h3>Product 1</h3>
            <p>$29.99</p>
        </div>
        <div class="product-card">
            <img src="product2.jpg" alt="Product 2">
            <h3>Product 2</h3>
            <p>$39.99</p>
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
    <p>We are a leading e-commerce store offering a wide range of products.</p>
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

<footer>
    <p>&copy; 2024 YourStore. All Rights Reserved.</p>
</footer>

<script src="script.js"></script>
</body>
</html>
-- Drop tables if they exist
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS authors;

-- Create the authors table
CREATE TABLE authors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    country VARCHAR(255) NOT NULL
);

-- Create the books table
CREATE TABLE books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    authorId INT NOT NULL,
    FOREIGN KEY (authorId) REFERENCES authors(id)
);

-- Create the orders table
CREATE TABLE orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    bookId INT NOT NULL,
    quantity INT NOT NULL,
    orderDate DATE NOT NULL,
    FOREIGN KEY (bookId) REFERENCES books(id)
);

SELECT * FROM northwind.Products;

-- Question 4

SELECT productID, productName, UnitPrice
FROM Products
WHERE UnitPrice < 7.50
ORDER BY UnitPrice;

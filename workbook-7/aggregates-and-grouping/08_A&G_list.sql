SELECT * FROM northwind.Products;

-- Question 8

SELECT SupplierID, COUNT(*) AS ItemCount
FROM Products
GROUP BY SupplierID
HAVING ItemCount >= 5;
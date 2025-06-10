SELECT * FROM northwind.Products;

SELECT SupplierID, COUNT(*) AS ItemCount
FROM Products
GROUP BY SupplierID;


-- Question 6
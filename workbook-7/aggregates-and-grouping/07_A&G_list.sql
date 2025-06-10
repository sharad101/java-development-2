SELECT * FROM northwind.Products;

-- Question 7

SELECT CategoryID, AVG(UnitPrice) as AveragePrice
FROM Products
GROUP BY CategoryID;



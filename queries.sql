--  1 SELECT c.fname as First, c.lname as Last, c.custID as custID 
-- FROM Customer c 
-- WHERE c.fname LIKE ? OR c.lname LIKE ?;
-- SELECT countryCode ,name from Country 
-- -- SELECT catID,name from Category
SELECT *
FROM Product
WHERE prodID='US-TEC-PH-10002262';
-- SELECT sc.subCatID,sc.name,c.name as category from SubCategory sc INNER JOIN Category c ON sc.catID=c.catID;
-- SELECT p.name as product_name, p.price as price, o.discount as discounts FROM OrderDetails o INNER JOIN Product p ON o.prodID=p.prodID INNER JOIN SubCategory sc ON p.subCatID = sc.subCatID INNER JOIN Category c ON sc.catID=c.catID WHERE o.discount > 0.6 AND c.name = 'Office Supplies' ;
-- SELECT * FROM Category
-- SELECT p.name AS name, p.price AS price, o.shipMode AS shipMode
-- FROM Product p
-- INNER JOIN OrderDetails od ON p.prodID = od.prodID
-- INNER JOIN [order] o ON od.orderID = o.orderID
-- WHERE o.orderID = 'CA-2019-105270'; -- Using parameterized query
-- SELECT Category.name AS category_name, SUM(OrderDetails.sales) AS total_sales
-- FROM Category
--     JOIN SubCategory ON Category.catID = SubCategory.catID
--     JOIN Product ON SubCategory.subCatID = Product.subCatID
--     JOIN OrderDetails ON Product.prodID = OrderDetails.prodID
-- GROUP BY Category.name;
-- SELECT * FROM [order]
-- SELECT * FROM Product
-- SELECT c.name as category, sb.name as subcategory, count(DISTINCT p.prodID) AS num_products, SUM(od.quantity) AS total_quantity_sold
-- FROM Product p
--     JOIN SubCategory sb ON p.subCatID = sb.subCatID
--     JOIN Category c ON sb.catID = c.catID
--     JOIN OrderDetails od ON p.prodID = od.prodID
--     JOIN [order] o ON od.orderID = o.orderID
-- WHERE o.isReturned=0
-- GROUP BY  c.name, sb.name
-- ORDER BY c.name, num_products desc;
-- SELECT * FROM Customer
SELECT *
FROM Category
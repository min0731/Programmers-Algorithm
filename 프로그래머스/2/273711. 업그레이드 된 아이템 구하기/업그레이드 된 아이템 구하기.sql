SELECT T.ITEM_ID, I2.ITEM_NAME, I2.RARITY
FROM 
    (SELECT * FROM ITEM_INFO WHERE RARITY = 'RARE') I 
LEFT JOIN ITEM_TREE T ON I.ITEM_ID = T.PARENT_ITEM_ID 
JOIN ITEM_INFO I2 ON I2.ITEM_ID = T.ITEM_ID 
ORDER BY T.ITEM_ID DESC;
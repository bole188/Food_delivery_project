CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `order_items` AS
    SELECT 
        `o`.`order_id` AS `order_id`,
        GROUP_CONCAT(`i`.`item_name`
            ORDER BY `i`.`item_name` ASC
            SEPARATOR ', ') AS `item_list`,
        SUM(`i`.`item_quantity`) AS `total_quantity`,
        SUM((`i`.`item_price` * `i`.`item_quantity`)) AS `total_price`
    FROM
        (`order` `o`
        JOIN `item` `i` ON ((`o`.`order_id` = `i`.`order_id`)))
    GROUP BY `o`.`order_id`
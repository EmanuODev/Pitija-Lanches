CREATE TRIGGER tg_update_price
    AFTER
        INSERT
    ON orders_itens
    FOR EACH ROW
BEGIN

    UPDATE orders
    SET orders.total_price = orders.total_price + NEW.subtotal
    WHERE orders.id = NEW.order_id;

END
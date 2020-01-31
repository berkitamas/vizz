package hu.szte.vizz.model.order;

/**
 * Represents the methods of the payment.
 *
 * @author <a href="mailto:h748276@stud.u-szeged.hu">Tamas Berki</a>
 */
public enum PaymentMethod {
    /**
     * Bank transaction
     *
     * It will be paid after the order is placed.
     */
    WIRE_TRANSFER,

    /**
     * Cash On Delivery
     *
     * It will be paid after the order is shipped.
     */
    COD
}

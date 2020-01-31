package hu.szte.vizz.model.order;

/**
 * Represents the statuses of the order.
 *
 * @author <a href="mailto:h748276@stud.u-szeged.hu">Tamas Berki</a>
 */
public enum OrderStatus {
    /**
     * Order is in pending state.
     *
     * This is the default state.
     */
    PENDING,

    /**
     * Order has been cancelled.
     *
     * If there was a transaction then the next state will be {@link #REFUNDED}.
     */
    CANCELLED,

    /**
     * Order has been placed and awaiting payment.
     */
    AWAITING_PAYMENT,

    /**
     * Order has been paid and awaiting shipment.
     */
    AWAITING_SHIPMENT,

    /**
     * Order has been shipped and awaiting user confirmation (possibly with a review).
     */
    SHIPPED,

    /**
     * Order has been shipped, and the user confirmed it.
     */
    COMPLETED,

    /**
     * Order has been successfully refunded.
     */
    REFUNDED
}

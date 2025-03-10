package alcatraz.devicecheck.receipt

import java.time.Instant

sealed class ReceiptException(
    message: String,
    cause: Throwable? = null,
) : RuntimeException(message, cause) {
    class InvalidCertificateChain(
        msg: String,
        cause: Throwable? = null,
    ) : ReceiptException(msg, cause)

    class InvalidSignature(
        msg: String,
    ) : ReceiptException(msg)

    class InvalidPayload(
        msg: String,
    ) : ReceiptException(msg)
}

sealed class ReceiptExchangeException(
    message: String,
    cause: Throwable? = null,
) : RuntimeException(message, cause) {
    class ReceiptExpired(
        expiredAt: Instant,
    ) : ReceiptExchangeException("The passed receipt has expired on $expiredAt")

    class HttpError(
        message: String,
        cause: Throwable? = null,
    ) : ReceiptExchangeException(message, cause)
}

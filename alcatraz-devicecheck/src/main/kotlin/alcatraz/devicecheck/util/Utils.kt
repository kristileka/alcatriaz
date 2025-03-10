package alcatraz.devicecheck.util

import org.bouncycastle.util.io.pem.PemReader
import java.security.cert.CertificateFactory
import java.security.cert.X509Certificate

internal object Utils {
    fun readPemX509Certificate(pem: String) = readDerX509Certificate(PemReader(pem.byteInputStream().reader()).readPemObject().content)

    fun readDerX509Certificate(der: ByteArray) =
        CertificateFactory.getInstance("X509").generateCertificate(der.inputStream()) as X509Certificate
}

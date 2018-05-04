package services

import javax.crypto.{Cipher, KeyGenerator}
import javax.inject._

import org.apache.commons.codec.binary.Base64
import play.api.Configuration
import sun.misc.{BASE64Decoder, BASE64Encoder}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Future, Promise}


trait CryptoService {
  def encrypt(uid: String): Future[String]
  def decrypt(uid: String): Future[String]
}

@Singleton
class CryptoServiceImpl extends CryptoService {
  val key = {
    val keyGen = KeyGenerator.getInstance("AES")
    keyGen.generateKey()
  }

  def encrypt(uid: String): Future[String] = {
    val p = Promise[String]()
    Future {
      val cipher = Cipher.getInstance("AES")
      cipher.init(Cipher.ENCRYPT_MODE, key)
      val encrypted = cipher.doFinal(uid.getBytes())
      val encoded = new BASE64Encoder().encode(encrypted)
      p.success(encoded)
    }
    p.future
  }

  def decrypt(uid: String): Future[String] = {
    val p = Promise[String]()
    Future {
      val decoded = new BASE64Decoder().decodeBuffer(uid)
      val cipher = Cipher.getInstance("AES")
      cipher.init(Cipher.DECRYPT_MODE, key)
      val res = cipher.doFinal(decoded)
      val id = new String(res, "UTF-8")
      p.success(id)
    }
    p.future
  }
}
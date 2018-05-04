import com.google.inject.AbstractModule
import db._
import services._

class Module extends AbstractModule {
  override def configure() = {
    bind(classOf[TypingTestService]).to(classOf[TypingTestServiceImpl])
    bind(classOf[DatabaseService]).to(classOf[DatabaseServiceImpl])
    bind(classOf[CryptoService]).to(classOf[CryptoServiceImpl])
  }
}

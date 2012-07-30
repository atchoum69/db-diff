import models.Database;

import org.junit.*;

import com.avaje.ebean.Ebean;

import play.mvc.*;
import play.test.*;
import play.libs.F.*;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

public class GlobalTest {

  @Test
  public void onStart() {
      running(fakeApplication(inMemoryDatabase()), new Runnable() {
         public void run() {
           // normalement la classe Global est executee automatiquement
           // donc on devrait avec la base chargee
           assertThat(Ebean.find(Database.class).findRowCount()).isEqualTo(10);
         }
      });
  }
}

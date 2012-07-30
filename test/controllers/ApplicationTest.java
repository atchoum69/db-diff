package controllers;

import models.Analyse;
import models.Database;

import org.junit.*;

import com.avaje.ebean.Ebean;

import play.mvc.*;
import play.test.*;
import play.libs.F.*;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

public class ApplicationTest {

  @Test
  public void callIndex() {
    running(fakeApplication(inMemoryDatabase()), new Runnable() {
      public void run() {
        Result result = callAction(controllers.routes.ref.Application.index());   
        assertThat(status(result)).isEqualTo(OK);
        assertThat(contentType(result)).isEqualTo("text/html");
        assertThat(charset(result)).isEqualTo("utf-8");
        assertThat(contentAsString(result)).contains("DEV3");
      }
    });
  }
  
  @Test
  public void callLancerAnalyse() {
    running(fakeApplication(inMemoryDatabase()), new Runnable() {
      public void run() {
        
        assertThat(Ebean.find(Analyse.class).findRowCount()).isEqualTo(0);
        
        Result result = callAction(controllers.routes.ref.Application.lancerAnalyse(Long.valueOf(1), Long.valueOf(2)));   
        assertThat(status(result)).isEqualTo(OK);
        assertThat(contentType(result)).isEqualTo("text/plain");
        assertThat(charset(result)).isEqualTo("utf-8");
        assertThat(contentAsString(result)).contains("ok");
        
        assertThat(Ebean.find(Analyse.class).findRowCount()).isEqualTo(1);
      }
    });
  }
}

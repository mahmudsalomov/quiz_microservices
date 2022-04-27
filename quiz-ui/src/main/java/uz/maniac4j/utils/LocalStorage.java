//package uz.maniac4j.utils;
//
//import com.vaadin.flow.component.*;
//import com.vaadin.flow.server.VaadinSession;
//import elemental.json.JsonObject;
//
//import java.util.*;
//import java.util.concurrent.CompletableFuture;
//
//@Tag("span")
//public class LocalStorage extends Component {
//
//    @FunctionalInterface
//    public interface LocalStorageInitListener {
//        void onInit(LocalStorage storage);
//    }
//
//    private Collection<LocalStorageInitListener> listeners = new ArrayList<>();
//    private JsonObject localStorage;
//
//
//    @Override
//    protected void onAttach(AttachEvent attachEvent) {
//        UI.getCurrent().getSession().accessSynchronously(() -> {
//            UI.getCurrent().getPage().executeJavaScript("$0.$server.init(localStorage)", this.getElement());
//        });
//    }
//
//    public String getString(String key) {
//        try {
//            return localStorage.getString(key);
//        } catch (NullPointerException e) {
//            return "";
//        }
//    }
//
//    public void addInitListener(LocalStorageInitListener listener) {
//        listeners.add(listener);
//    }
//
//    public void setValue(String key, String value) {
//        UI.getCurrent().getPage().executeJavaScript("localStorage.setItem($0, $1)", key, value);
//    }
//
//    public String getValue(String key) {
//
//        VaadinSession session=VaadinSession.getCurrent();
//        UI.getCurrent().getPage().executeJs("return localStorage.getItem(\"aaa\")", key)
//                .then(result-> System.out.println(result.asString()));
//        return key;
//    }
//
//    @ClientCallable
//    public void init(JsonObject localStorage) {
//        UI.getCurrent().getSession().access(() -> {
//            this.localStorage = localStorage;
//            listeners.forEach(v -> v.onInit(this));
//        });
//    }
//}

package api;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerRequest;
import io.helidon.webserver.ServerResponse;
import io.helidon.webserver.Service;
import java.util.Map;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.CompletionStage;

public class FornecedorService implements Service {
    private final Map<String, JsonObject> fornecedores;

    public FornecedorService() {
        this.fornecedores = new HashMap<>();
    }

    @Override
    public void update(Routing.Rules rules) {
        rules
            .get("/", this::getDefaultMessageHandler)
            .get("/{id}", this::getHandler)
            .post("/", this::createHandler)
            .put("/{id}", this::updateHandler)
            .delete("/{id}", this::deleteHandler);
    }

    private synchronized void getDefaultMessageHandler(
        ServerRequest request, 
        ServerResponse response
    ) {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        fornecedores.values().forEach(builder::add);

        JsonObject result = Json.createObjectBuilder()
                .add("items", builder.build())
                .build();

        response.status(200).send(result.toString());
    }

    private synchronized void getHandler(
        ServerRequest request, 
        ServerResponse response
    ) {
        JsonObject user = fornecedores.get(getID(request));

        if (user != null) {
            response.status(200).send(user);
        } else {
            response.status(404).send();
        }
    }

    private synchronized void createHandler(
        ServerRequest request, 
        ServerResponse response
    ) {
        CompletionStage<Void> value = request.content().as(JsonObject.class)
            .thenAccept(payload -> {
                // That's right, no validation for this sample service.
                String id = generateID();
                JsonObject user = Json.createObjectBuilder(payload)
                        .add("id", id)
                        .build();

                //fornecedores.put(id, user);
                //response.status(201).send(user);
            });
        System.out.println(value);
        response.status(201).send("user");
    }

    private synchronized void updateHandler(
        ServerRequest request, 
        ServerResponse response
    ) {
        request.content()
            .as(JsonObject.class)
            .thenAccept(payload -> {
                String id = getID(request);
                // Make sure the ID doesn't change.
                JsonObject user = Json.createObjectBuilder(payload)
                        .add("id", id)
                        .build();

                fornecedores.put(id, user);
                response.status(202).send(user);
            });
    }

    private synchronized void deleteHandler(
        ServerRequest request, 
        ServerResponse response
    ) {
        JsonObject user = fornecedores.remove(getID(request));

        if (user != null) {
            response.status(202).send(user);
        } else {
            response.status(404).send();
        }
    }

    private static String getID(ServerRequest req) {
        return req.path().param("id");
    }

    private static String generateID() {
        return UUID.randomUUID().toString();
    }
}

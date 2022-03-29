package uz.maniac4j.organizationservice.payload;


public enum HttpStatus {

    // 100
    Continue(100, "Continue", "The client should continue with its request."),
    SwitchingProtocols(101, "Switching Protocols", "Informs the client that the server will switch to the protocol specified in the Upgrade message header field."),

    // 200
    OK(200, "OK", "The request sent by the client was successful."),
    Created(201, "Created", "The request was successful and the resource has been created."),
    Accepted(202, "Accepted", "The request has been accepted but has not yet finished processing."),
    NonAuthoritativeInformation(203, "Non-Authoritative Information", "The returned meta-information in the entity header is not the definitative set of information, it might be a local copy or contain local alterations."),
    NoContent(204, "No Content", "The request was successful but not require the return of an entity body."),
    ResetContent(205, "Reset Content", "The request was successful and the user agent should reset the view that sent the request."),
    PartialContent(206, "Partial Content", "The partial request was successful."),

    // 300
    MultipleChoices(300, "Multiple Choices", "The requested resource has multiple choices, each of which has a different location."),
    MovedPermanently(301, "Moved Permanently", "The requested resources has moved permanently to a new location."),
    Found(302, "Found", "The requested resource has been found at a different location but the client should use the original URI."),
    SeeOther(303, "See Other", "The requested resource is located at a different location which should be returned by the location field in the response."),
    NotModified(304, "Not Modified", "The resource has not been modified since the last request."),
    UseProxy(305, "Use Proxy", "The requested resource can only be accessed through a proxy which should be provided in the location field."),
    UnUsed(306, "Unused", "This status code is no longer in use but is reserved for future use."),
    TemporaryRedirect(307, "Temporary Redirect", "The requested resource is temporarily moved to the provided location but the client should continue to use this location as the resource may again move."),

    // 400
    BadRequest(400, "Bad Request", "The request could not be understood by the server."),
    Unauthorized(401, "Unauthorized", "The request requires authorization."),
    PaymentRequired(402, "Payment Required", "Reserved for future use."),
    Forbidden(403, "Forbidden", "Whilst the server did understand the request, the server is refusing to complete it. This is not an authorization problem."),
    NotFound(404, "Not Found", "The requested resource was not found."),
    MethodNotAllowed(405, "Method Not Allowed", "The supplied method was not allowed on the given resource."),
    NotAcceptable(406, "Not Acceptable", "The resource is not able to return a response that is suitable for the characteristics required by the accept headers of the request."),
    ProxyAuthenticationRequired(407, "Proxy Authentication Required", "The client must authenticate themselves with the proxy."),
    RequestTimeout(408, "Request Timeout", "The client did not supply a request in the period required by the server."),
    Conflict(409, "Conflict", "The request could not be completed as the resource is in a conflicted state."),
    Gone(410, "Gone", "The requested resource is no longer available on the server and no redirect address is available."),
    LengthRequired(411, "Length Required", "The server will not accept the request without a Content-Length field."),
    PreconditionFailed(412, "Precondition Failed", "The supplied precondition evaluated to false on the server."),
    RequestEntityTooLarge(413, "Request Entity Too Large", "The request was unsuccessful because the request entity was larger than the server would allow"),
    RequestedURITooLong(414, "Request URI Too Long", "The request was unsuccessful because the requested URI is longer than the server is willing to process (that's what she said)."),
    UnsupportedMediaType(415, "Unsupported Media Type", "The request was unsuccessful because the request was for an unsupported format."),
    RequestRangeNotSatisfiable(416, "Request Range Not Satisfiable", "The range of the resource does not overlap with the values specified in the requests Range header field and not alternative If-Range field was supplied."),
    ExpectationFailed(417, "Expectation Failed", "The expectation supplied in the Expectation header field could not be met by the server."),
    ImATeapot(418, "I'm a teapot", "I'm a teapot"),

    // 500
    InternalServerError(500, "Internal Server Error", "The request was unsuccessful because the server encountered an unexpected error."),
    NotImplemented(501, "Not Implemented", "The server does not support the request."),
    BadGateway(502, "Bad Gateway", "The server, whilst acting as a proxy, received an invalid response from the server that was fulfilling the request."),
    ServiceUnavailable(503, "Service Unavailable", "The request was unsuccessful as the server is either down or slash^H^H^H^H^Hdug^H^H^Hreddited."),
    GatewayTimeout(504, "Gateway Timeout", "The server, whilst acting as a proxy, did not receive a response from the upstream server in an acceptable time."),
    HttpVersionNotSupported(505, "HTTP Version Not Supported", "The server does not supported the HTTP protocol version specified in the request"),

    Unknown(400, "Unknown HTTP Status Code", "Unknown or unsupported HTTP status code");

    private final int code;
    private final String name;
    private final String description;
    private final String jsonString;


    private HttpStatus(int code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.jsonString = generateJsonString();
    }


    public final int getCode() {
        return code;
    }


    public final String getName() {
        return name;
    }

    public final String getDescription() {
        return description;
    }


    public final String getJsonString() {
        return jsonString;
    }

    public static HttpStatus getByCode(int httpStatus) {
        for (HttpStatus status : HttpStatus.values()) {
            if (status.getCode() == httpStatus) {
                return status;
            }
        }
        return Unknown;
    }


    public static HttpStatus getByCode(String httpStatus) {
        int statusCode;
        try {
            statusCode = Integer.parseInt(httpStatus);
        } catch (NumberFormatException e) {
            return Unknown;
        }
        return getByCode(statusCode);
    }


    public String generateJsonString() {
        return String.format("{\"code\": %s, \"name\": \"%s\", \"description\": \"%s\"}", code, name, description);
    }



}

package uz.maniac4j.quizservice.payload;


public class Payload {



    /**
     * For responses
     **/

    public static Response api(HttpStatus status){
        return new ApiResponse(status);
    }

    public static Response api(String message,HttpStatus status){
        return new ApiResponse(message,status);
    }

    public static Response api(String message,boolean success){
        return new ApiResponse(message,success);
    }

    public static Response api(String message,boolean success,HttpStatus status){
        return new ApiResponse(message,success,status);
    }


    // with object
    public static Response api(HttpStatus status,Object object){
        return new ApiResponseObject<>(status,object);
    }

    public static Response api(String message,HttpStatus status,Object object){
        return new ApiResponseObject<>(message,status,object);
    }

    public static Response api(String message,boolean success,Object object){
        return new ApiResponseObject<>(message,success,object);
    }

    public static Response api(String message,boolean success,HttpStatus status,Object object){
        return new ApiResponseObject<>(message,success,status,object);
    }



    /** Success **/
    // Continue 100
    public static Response continues(){
        return api(HttpStatus.Continue);
    }
    public static Response continues(String message){
        return api(message,HttpStatus.Continue);
    }
    public static Response continues(Object object){
        return api(HttpStatus.Continue,object);
    }
    public static Response continues(String message,Object object){
        return api(message,HttpStatus.Continue,object);
    }
    // SwitchingProtocols 101
    public static Response switchingProtocols(){
        return api(HttpStatus.SwitchingProtocols);
    }
    public static Response switchingProtocols(String message){
        return api(message,HttpStatus.SwitchingProtocols);
    }
    public static Response switchingProtocols(Object object){
        return api(HttpStatus.SwitchingProtocols,object);
    }
    public static Response switchingProtocols(String message,Object object){
        return api(message,HttpStatus.SwitchingProtocols,object);
    }
    // OK 200
    public static Response ok(){
        return api(HttpStatus.OK);
    }
    public static Response ok(String message){
        return api(message,HttpStatus.OK);
    }
    public static Response ok(Object object){
        return api(HttpStatus.OK,object);
    }
    public static Response ok(String message,Object object){
        return api(message,HttpStatus.OK,object);
    }
    // Created 201
    public static Response created(){
        return api(HttpStatus.Created);
    }
    public static Response created(String message){
        return api(message,HttpStatus.Created);
    }
    public static Response created(Object object){
        return api(HttpStatus.Created,object);
    }
    public static Response created(String message,Object object){
        return api(message,HttpStatus.Created,object);
    }
    // Accepted 202
    public static Response accepted(){
        return api(HttpStatus.Accepted);
    }
    public static Response accepted(String message){
        return api(message,HttpStatus.Accepted);
    }
    public static Response accepted(Object object){
        return api(HttpStatus.Accepted,object);
    }
    public static Response accepted(String message,Object object){
        return api(message,HttpStatus.Accepted,object);
    }
    // NonAuthoritativeInformation 203
    public static Response nonAuthoritativeInformation(){
        return api(HttpStatus.NonAuthoritativeInformation);
    }
    public static Response nonAuthoritativeInformation(String message){
        return api(message,HttpStatus.NonAuthoritativeInformation);
    }
    public static Response nonAuthoritativeInformation(Object object){
        return api(HttpStatus.NonAuthoritativeInformation,object);
    }
    public static Response nonAuthoritativeInformation(String message,Object object){
        return api(message,HttpStatus.NonAuthoritativeInformation,object);
    }
    // NoContent 204
    public static Response noContent(){
        return api(HttpStatus.NoContent);
    }

    public static Response noContent(String message){
        return api(message,HttpStatus.NoContent);
    }
    public static Response noContent(Object object){
        return api(HttpStatus.NoContent,object);
    }
    public static Response noContent(String message,Object object){
        return api(message,HttpStatus.NoContent,object);
    }
    // ResetContent 205
    public static Response resetContent(){
        return api(HttpStatus.ResetContent);
    }
    public static Response resetContent(String message){
        return api(message,HttpStatus.ResetContent);
    }
    public static Response resetContent(Object object){
        return api(HttpStatus.ResetContent,object);
    }
    public static Response resetContent(String message,Object object){
        return api(message,HttpStatus.ResetContent,object);
    }
    // PartialContent 206
    public static Response partialContent(){
        return api(HttpStatus.PartialContent);
    }
    public static Response partialContent(String message){
        return api(message,HttpStatus.PartialContent);
    }
    public static Response partialContent(Object object){
        return api(HttpStatus.PartialContent,object);
    }
    public static Response partialContent(String message,Object object){
        return api(message,HttpStatus.PartialContent,object);
    }
    // PartialContent 300
    public static Response multipleChoices(){
        return api(HttpStatus.MultipleChoices);
    }
    public static Response multipleChoices(String message){
        return api(message,HttpStatus.MultipleChoices);
    }
    public static Response multipleChoices(Object object){
        return api(HttpStatus.MultipleChoices,object);
    }
    public static Response multipleChoices(String message,Object object){
        return api(message,HttpStatus.MultipleChoices,object);
    }
    // MovedPermanently 301
    public static Response movedPermanently(){
        return api(HttpStatus.MovedPermanently);
    }
    public static Response movedPermanently(String message){
        return api(message,HttpStatus.MovedPermanently);
    }
    public static Response movedPermanently(Object object){
        return api(HttpStatus.MovedPermanently,object);
    }
    public static Response movedPermanently(String message,Object object){
        return api(message,HttpStatus.MovedPermanently,object);
    }
    // Found 302
    public static Response found(){
        return api(HttpStatus.Found);
    }
    public static Response found(String message){
        return api(message,HttpStatus.Found);
    }
    public static Response found(Object object){
        return api(HttpStatus.Found,object);
    }
    public static Response found(String message,Object object){
        return api(message,HttpStatus.Found,object);
    }
    // SeeOther 303
    public static Response seeOther(){
        return api(HttpStatus.SeeOther);
    }
    public static Response seeOther(String message){
        return api(message,HttpStatus.SeeOther);
    }
    public static Response seeOther(Object object){
        return api(HttpStatus.SeeOther,object);
    }
    public static Response seeOther(String message,Object object){
        return api(message,HttpStatus.SeeOther,object);
    }
    // NotModified 304
    public static Response notModified(){
        return api(HttpStatus.NotModified);
    }
    public static Response notModified(String message){
        return api(message,HttpStatus.NotModified);
    }
    public static Response notModified(Object object){
        return api(HttpStatus.NotModified,object);
    }
    public static Response notModified(String message,Object object){
        return api(message,HttpStatus.NotModified,object);
    }
    // UseProxy 305
    public static Response useProxy(){
        return api(HttpStatus.UseProxy);
    }
    public static Response useProxy(String message){
        return api(message,HttpStatus.UseProxy);
    }
    public static Response useProxy(Object object){
        return api(HttpStatus.UseProxy,object);
    }

    public static Response useProxy(String message,Object object){
        return api(message,HttpStatus.UseProxy,object);
    }
    // UnUsed 306
    public static Response unUsed(){
        return api(HttpStatus.UnUsed);
    }
    public static Response unUsed(String message){
        return api(message,HttpStatus.UnUsed);
    }
    public static Response unUsed(Object object){
        return api(HttpStatus.UnUsed,object);
    }
    public static Response unUsed(String message,Object object){
        return api(message,HttpStatus.UnUsed,object);
    }
    // TemporaryRedirect 307
    public static Response temporaryRedirect(){
        return api(HttpStatus.TemporaryRedirect);
    }
    public static Response temporaryRedirect(String message){
        return api(message,HttpStatus.TemporaryRedirect);
    }
    public static Response temporaryRedirect(Object object){
        return api(HttpStatus.TemporaryRedirect,object);
    }
    public static Response temporaryRedirect(String message,Object object){
        return api(message,HttpStatus.TemporaryRedirect,object);
    }


    /** Errors **/

    // BadRequest
    public static Response badRequest(){
        return api(HttpStatus.BadRequest);
    }
    public static Response badRequest(String message){
        return api(message,HttpStatus.BadRequest);
    }
    public static Response badRequest(Object object){
        return api(HttpStatus.BadRequest,object);
    }
    public static Response badRequest(String message,Object object){
        return api(message,HttpStatus.BadRequest,object);
    }
    // Unauthorized
    public static Response unauthorized(){
        return api(HttpStatus.Unauthorized);
    }
    public static Response unauthorized(String message){
        return api(message,HttpStatus.Unauthorized);
    }
    public static Response unauthorized(Object object){
        return api(HttpStatus.Unauthorized,object);
    }
    public static Response unauthorized(String message,Object object){
        return api(message,HttpStatus.Unauthorized,object);
    }
    // PaymentRequired
    public static Response paymentRequired(){
        return api(HttpStatus.PaymentRequired);
    }
    public static Response paymentRequired(String message){
        return api(message,HttpStatus.PaymentRequired);
    }
    public static Response paymentRequired(Object object){
        return api(HttpStatus.PaymentRequired,object);
    }
    public static Response paymentRequired(String message,Object object){
        return api(message,HttpStatus.PaymentRequired,object);
    }
    // Forbidden
    public static Response forbidden(){
        return api(HttpStatus.Forbidden);
    }
    public static Response forbidden(String message){
        return api(message,HttpStatus.Forbidden);
    }
    public static Response forbidden(Object object){
        return api(HttpStatus.Forbidden,object);
    }
    public static Response forbidden(String message,Object object){
        return api(message,HttpStatus.Forbidden,object);
    }
    // NotFound
    public static Response notFound(){
        return api(HttpStatus.NotFound);
    }
    public static Response notFound(String message){
        return api(message,HttpStatus.NotFound);
    }
    public static Response notFound(Object object){
        return api(HttpStatus.NotFound,object);
    }
    public static Response notFound(String message,Object object){
        return api(message,HttpStatus.NotFound,object);
    }
    // MethodNotAllowed
    public static Response methodNotAllowed(){
        return api(HttpStatus.MethodNotAllowed);
    }
    public static Response methodNotAllowed(String message){
        return api(message,HttpStatus.MethodNotAllowed);
    }
    public static Response methodNotAllowed(Object object){
        return api(HttpStatus.MethodNotAllowed,object);
    }
    public static Response methodNotAllowed(String message,Object object){
        return api(message,HttpStatus.MethodNotAllowed,object);
    }
    // NotAcceptable
    public static Response notAcceptable(){
        return api(HttpStatus.NotAcceptable);
    }
    public static Response notAcceptable(String message){
        return api(message,HttpStatus.NotAcceptable);
    }
    public static Response notAcceptable(Object object){
        return api(HttpStatus.NotAcceptable,object);
    }
    public static Response notAcceptable(String message,Object object){
        return api(message,HttpStatus.NotAcceptable,object);
    }
    // ProxyAuthenticationRequired
    public static Response proxyAuthenticationRequired(){
        return api(HttpStatus.ProxyAuthenticationRequired);
    }
    public static Response proxyAuthenticationRequired(String message){
        return api(message,HttpStatus.ProxyAuthenticationRequired);
    }
    public static Response proxyAuthenticationRequired(Object object){
        return api(HttpStatus.ProxyAuthenticationRequired,object);
    }
    public static Response proxyAuthenticationRequired(String message,Object object){
        return api(message,HttpStatus.ProxyAuthenticationRequired,object);
    }
    // RequestTimeout
    public static Response requestTimeout(){
        return api(HttpStatus.RequestTimeout);
    }
    public static Response requestTimeout(String message){
        return api(message,HttpStatus.RequestTimeout);
    }
    public static Response requestTimeout(Object object){
        return api(HttpStatus.RequestTimeout,object);
    }
    public static Response requestTimeout(String message,Object object){
        return api(message,HttpStatus.RequestTimeout,object);
    }
    // Conflict
    public static Response conflict(){
        return api(HttpStatus.Conflict);
    }
    public static Response conflict(String message){
        return api(message,HttpStatus.Conflict);
    }
    public static Response conflict(Object object){
        return api(HttpStatus.Conflict,object);
    }
    public static Response conflict(String message,Object object){
        return api(message,HttpStatus.Conflict,object);
    }
    // Gone
    public static Response gone(){
        return api(HttpStatus.Gone);
    }
    public static Response gone(String message){
        return api(message,HttpStatus.Gone);
    }
    public static Response gone(Object object){
        return api(HttpStatus.Gone,object);
    }
    public static Response gone(String message,Object object){
        return api(message,HttpStatus.Gone,object);
    }
    // LengthRequired
    public static Response lengthRequired(){
        return api(HttpStatus.LengthRequired);
    }
    public static Response lengthRequired(String message){
        return api(message,HttpStatus.LengthRequired);
    }
    public static Response lengthRequired(Object object){
        return api(HttpStatus.LengthRequired,object);
    }
    public static Response lengthRequired(String message,Object object){
        return api(message,HttpStatus.LengthRequired,object);
    }
    // PreconditionFailed
    public static Response preconditionFailed(){
        return api(HttpStatus.PreconditionFailed);
    }
    public static Response preconditionFailed(String message){
        return api(message,HttpStatus.PreconditionFailed);
    }
    public static Response preconditionFailed(Object object){
        return api(HttpStatus.PreconditionFailed,object);
    }
    public static Response preconditionFailed(String message,Object object){
        return api(message,HttpStatus.PreconditionFailed,object);
    }
    // RequestEntityTooLarge
    public static Response requestEntityTooLarge(){
        return api(HttpStatus.RequestEntityTooLarge);
    }
    public static Response requestEntityTooLarge(String message){
        return api(message,HttpStatus.RequestEntityTooLarge);
    }
    public static Response requestEntityTooLarge(Object object){
        return api(HttpStatus.RequestEntityTooLarge,object);
    }
    public static Response requestEntityTooLarge(String message,Object object){
        return api(message,HttpStatus.RequestEntityTooLarge,object);
    }
    // RequestedURITooLong
    public static Response requestedURITooLong(){
        return api(HttpStatus.RequestedURITooLong);
    }
    public static Response requestedURITooLong(String message){
        return api(message,HttpStatus.RequestedURITooLong);
    }
    public static Response requestedURITooLong(Object object){
        return api(HttpStatus.RequestedURITooLong,object);
    }
    public static Response requestedURITooLong(String message,Object object){
        return api(message,HttpStatus.RequestedURITooLong,object);
    }
    // UnsupportedMediaType
    public static Response unsupportedMediaType(){
        return api(HttpStatus.UnsupportedMediaType);
    }
    public static Response unsupportedMediaType(String message){
        return api(message,HttpStatus.UnsupportedMediaType);
    }
    public static Response unsupportedMediaType(Object object){
        return api(HttpStatus.UnsupportedMediaType,object);
    }
    public static Response unsupportedMediaType(String message,Object object){
        return api(message,HttpStatus.UnsupportedMediaType,object);
    }
    // RequestRangeNotSatisfiable
    public static Response requestRangeNotSatisfiable(){
        return api(HttpStatus.RequestRangeNotSatisfiable);
    }
    public static Response requestRangeNotSatisfiable(String message){
        return api(message,HttpStatus.RequestRangeNotSatisfiable);
    }
    public static Response requestRangeNotSatisfiable(Object object){
        return api(HttpStatus.RequestRangeNotSatisfiable,object);
    }
    public static Response requestRangeNotSatisfiable(String message,Object object){
        return api(message,HttpStatus.RequestRangeNotSatisfiable,object);
    }
    // ExpectationFailed
    public static Response expectationFailed(){
        return api(HttpStatus.ExpectationFailed);
    }
    public static Response expectationFailed(String message){
        return api(message,HttpStatus.ExpectationFailed);
    }
    public static Response expectationFailed(Object object){
        return api(HttpStatus.ExpectationFailed,object);
    }
    public static Response expectationFailed(String message,Object object){
        return api(message,HttpStatus.ExpectationFailed,object);
    }
    // ImATeapot
    public static Response imATeapot(){
        return api(HttpStatus.ImATeapot);
    }
    public static Response imATeapot(String message){
        return api(message,HttpStatus.ImATeapot);
    }
    public static Response imATeapot(Object object){
        return api(HttpStatus.ImATeapot,object);
    }
    public static Response imATeapot(String message,Object object){
        return api(message,HttpStatus.ImATeapot,object);
    }
    // InternalServerError
    public static Response internalServerError(){
        return api(HttpStatus.InternalServerError);
    }
    public static Response internalServerError(String message){
        return api(message,HttpStatus.InternalServerError);
    }
    public static Response internalServerError(Object object){
        return api(HttpStatus.InternalServerError,object);
    }
    public static Response internalServerError(String message,Object object){
        return api(message,HttpStatus.InternalServerError,object);
    }
    // NotImplemented
    public static Response notImplemented(){
        return api(HttpStatus.NotImplemented);
    }
    public static Response notImplemented(String message){
        return api(message,HttpStatus.NotImplemented);
    }
    public static Response notImplemented(Object object){
        return api(HttpStatus.NotImplemented,object);
    }
    public static Response notImplemented(String message,Object object){
        return api(message,HttpStatus.NotImplemented,object);
    }
    // BadGateway
    public static Response badGateway(){
        return api(HttpStatus.BadGateway);
    }
    public static Response badGateway(String message){
        return api(message,HttpStatus.BadGateway);
    }
    public static Response badGateway(Object object){
        return api(HttpStatus.BadGateway,object);
    }
    public static Response badGateway(String message,Object object){
        return api(message,HttpStatus.BadGateway,object);
    }
    // ServiceUnavailable
    public static Response serviceUnavailable(){
        return api(HttpStatus.ServiceUnavailable);
    }
    public static Response serviceUnavailable(String message){
        return api(message,HttpStatus.ServiceUnavailable);
    }
    public static Response serviceUnavailable(Object object){
        return api(HttpStatus.ServiceUnavailable,object);
    }
    public static Response serviceUnavailable(String message,Object object){
        return api(message,HttpStatus.ServiceUnavailable,object);
    }
    // GatewayTimeout
    public static Response gatewayTimeout(){
        return api(HttpStatus.GatewayTimeout);
    }
    public static Response gatewayTimeout(String message){
        return api(message,HttpStatus.GatewayTimeout);
    }
    public static Response gatewayTimeout(Object object){
        return api(HttpStatus.GatewayTimeout,object);
    }
    public static Response gatewayTimeout(String message,Object object){
        return api(message,HttpStatus.GatewayTimeout,object);
    }
    // HttpVersionNotSupported
    public static Response httpVersionNotSupported(){
        return api(HttpStatus.HttpVersionNotSupported);
    }
    public static Response httpVersionNotSupported(String message){
        return api(message,HttpStatus.HttpVersionNotSupported);
    }
    public static Response httpVersionNotSupported(Object object){
        return api(HttpStatus.HttpVersionNotSupported,object);
    }
    public static Response httpVersionNotSupported(String message,Object object){
        return api(message,HttpStatus.HttpVersionNotSupported,object);
    }
    // Unknown
    public static Response unknown(){
        return api(HttpStatus.Unknown);
    }
    public static Response unknown(String message){
        return api(message,HttpStatus.Unknown);
    }
    public static Response unknown(Object object){
        return api(HttpStatus.Unknown,object);
    }
    public static Response unknown(String message,Object object){
        return api(message,HttpStatus.Unknown,object);
    }


}




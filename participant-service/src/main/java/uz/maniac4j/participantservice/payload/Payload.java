package uz.maniac4j.participantservice.payload;


import org.springframework.web.client.RestTemplate;
import uz.maniac4j.participantservice.participant.Participant;

public class Payload {



    /**
     * For responses
     **/

    public static <T> Response<T> api(HttpStatus status){
        return new ApiResponse<T>(status);
    }

    public static <T> Response<T> api(String message,HttpStatus status){
        return new ApiResponse<T>(message,status);
    }

    public static <T> Response<T> api(String message,boolean success){
        return new ApiResponse<T>(message,success);
    }

    public static <T> Response<T> api(String message,boolean success,HttpStatus status){
        return new ApiResponse<T>(message,success,status);
    }


    // with object
//    public static <T> Response<T api(HttpStatus status,T object){
//        return new ApiResponseObject<>(status,object);
//    }
//
//    public static <T> Response<T api(String message,HttpStatus status,T object){
//        return new ApiResponseObject<>(message,status,object);
//    }
//
//    public static <T> Response<T api(String message,boolean success,T object){
//        return new ApiResponseObject<>(message,success,object);
//    }
//
//    public static <T> Response<T api(String message,boolean success,HttpStatus status,T object){
//        return new ApiResponseObject<>(message,success,status,object);
//    }




    /** Test **/
    public static <T> Response<T> api(HttpStatus status,T object){
//        RestTemplate restTemplate=new RestTemplate();
//        restTemplate.getForObject("", Participant.class);
        return new ApiResponseObject<T>(status,object);
    }

    public static <T> Response<T> api(String message,HttpStatus status,T object){
        return new ApiResponseObject<T>(message,status,object);
    }

    public static <T> Response<T> api(String message,boolean success,T object){
        return new ApiResponseObject<>(message,success,object);
    }

    public static <T> Response<T> api(String message,boolean success,HttpStatus status,T object){
        return new ApiResponseObject<T>(message,success,status,object);
    }



    /** Success **/
    // Continue 100
    public static <T> Response<T> continues(){
        return api(HttpStatus.Continue);
    }
    public static <T> Response<T> continues(String message){
        return api(message,HttpStatus.Continue);
    }
    public static <T> Response<T> continues(T object){
        return api(HttpStatus.Continue,object);
    }
    public static <T> Response<T> continues(String message,T object){
        return api(message,HttpStatus.Continue,object);
    }
    // SwitchingProtocols 101
    public static <T> Response<T> switchingProtocols(){
        return api(HttpStatus.SwitchingProtocols);
    }
    public static <T> Response<T> switchingProtocols(String message){
        return api(message,HttpStatus.SwitchingProtocols);
    }
    public static <T> Response<T> switchingProtocols(T object){
        return api(HttpStatus.SwitchingProtocols,object);
    }
    public static <T> Response<T> switchingProtocols(String message,T object){
        return api(message,HttpStatus.SwitchingProtocols,object);
    }
    // OK 200
    public static <T> Response<T> ok(){
        return api(HttpStatus.OK);
    }
    public static <T> Response<T> ok(String message){
        return api(message,HttpStatus.OK);
    }
    public static <T> Response<T> ok(T object){
        return api(HttpStatus.OK,object);
    }
    public static <T> Response<T> ok(String message,T object){
        return api(message,HttpStatus.OK,object);
    }
    // Created 201
    public static <T> Response<T> created(){
        return api(HttpStatus.Created);
    }
    public static <T> Response<T> created(String message){
        return api(message,HttpStatus.Created);
    }
    public static <T> Response<T> created(T object){
        return api(HttpStatus.Created,object);
    }
    public static <T> Response<T> created(String message,T object){
        return api(message,HttpStatus.Created,object);
    }
    // Accepted 202
    public static <T> Response<T> accepted(){
        return api(HttpStatus.Accepted);
    }
    public static <T> Response<T> accepted(String message){
        return api(message,HttpStatus.Accepted);
    }
    public static <T> Response<T> accepted(T object){
        return api(HttpStatus.Accepted,object);
    }
    public static <T> Response<T> accepted(String message,T object){
        return api(message,HttpStatus.Accepted,object);
    }
    // NonAuthoritativeInformation 203
    public static <T> Response<T> nonAuthoritativeInformation(){
        return api(HttpStatus.NonAuthoritativeInformation);
    }
    public static <T> Response<T> nonAuthoritativeInformation(String message){
        return api(message,HttpStatus.NonAuthoritativeInformation);
    }
    public static <T> Response<T> nonAuthoritativeInformation(T object){
        return api(HttpStatus.NonAuthoritativeInformation,object);
    }
    public static <T> Response<T> nonAuthoritativeInformation(String message,T object){
        return api(message,HttpStatus.NonAuthoritativeInformation,object);
    }
    // NoContent 204
    public static <T> Response<T> noContent(){
        return api(HttpStatus.NoContent);
    }

    public static <T> Response<T> noContent(String message){
        return api(message,HttpStatus.NoContent);
    }
    public static <T> Response<T> noContent(T object){
        return api(HttpStatus.NoContent,object);
    }
    public static <T> Response<T> noContent(String message,T object){
        return api(message,HttpStatus.NoContent,object);
    }
    // ResetContent 205
    public static <T> Response<T> resetContent(){
        return api(HttpStatus.ResetContent);
    }
    public static <T> Response<T> resetContent(String message){
        return api(message,HttpStatus.ResetContent);
    }
    public static <T> Response<T> resetContent(T object){
        return api(HttpStatus.ResetContent,object);
    }
    public static <T> Response<T> resetContent(String message,T object){
        return api(message,HttpStatus.ResetContent,object);
    }
    // PartialContent 206
    public static <T> Response<T> partialContent(){
        return api(HttpStatus.PartialContent);
    }
    public static <T> Response<T> partialContent(String message){
        return api(message,HttpStatus.PartialContent);
    }
    public static <T> Response<T> partialContent(T object){
        return api(HttpStatus.PartialContent,object);
    }
    public static <T> Response<T> partialContent(String message,T object){
        return api(message,HttpStatus.PartialContent,object);
    }
    // PartialContent 300
    public static <T> Response<T> multipleChoices(){
        return api(HttpStatus.MultipleChoices);
    }
    public static <T> Response<T> multipleChoices(String message){
        return api(message,HttpStatus.MultipleChoices);
    }
    public static <T> Response<T> multipleChoices(T object){
        return api(HttpStatus.MultipleChoices,object);
    }
    public static <T> Response<T> multipleChoices(String message,T object){
        return api(message,HttpStatus.MultipleChoices,object);
    }
    // MovedPermanently 301
    public static <T> Response<T> movedPermanently(){
        return api(HttpStatus.MovedPermanently);
    }
    public static <T> Response<T> movedPermanently(String message){
        return api(message,HttpStatus.MovedPermanently);
    }
    public static <T> Response<T> movedPermanently(T object){
        return api(HttpStatus.MovedPermanently,object);
    }
    public static <T> Response<T> movedPermanently(String message,T object){
        return api(message,HttpStatus.MovedPermanently,object);
    }
    // Found 302
    public static <T> Response<T> found(){
        return api(HttpStatus.Found);
    }
    public static <T> Response<T> found(String message){
        return api(message,HttpStatus.Found);
    }
    public static <T> Response<T> found(T object){
        return api(HttpStatus.Found,object);
    }
    public static <T> Response<T> found(String message,T object){
        return api(message,HttpStatus.Found,object);
    }
    // SeeOther 303
    public static <T> Response<T> seeOther(){
        return api(HttpStatus.SeeOther);
    }
    public static <T> Response<T> seeOther(String message){
        return api(message,HttpStatus.SeeOther);
    }
    public static <T> Response<T> seeOther(T object){
        return api(HttpStatus.SeeOther,object);
    }
    public static <T> Response<T> seeOther(String message,T object){
        return api(message,HttpStatus.SeeOther,object);
    }
    // NotModified 304
    public static <T> Response<T> notModified(){
        return api(HttpStatus.NotModified);
    }
    public static <T> Response<T> notModified(String message){
        return api(message,HttpStatus.NotModified);
    }
    public static <T> Response<T> notModified(T object){
        return api(HttpStatus.NotModified,object);
    }
    public static <T> Response<T> notModified(String message,T object){
        return api(message,HttpStatus.NotModified,object);
    }
    // UseProxy 305
    public static <T> Response<T> useProxy(){
        return api(HttpStatus.UseProxy);
    }
    public static <T> Response<T> useProxy(String message){
        return api(message,HttpStatus.UseProxy);
    }
    public static <T> Response<T> useProxy(T object){
        return api(HttpStatus.UseProxy,object);
    }

    public static <T> Response<T> useProxy(String message,T object){
        return api(message,HttpStatus.UseProxy,object);
    }
    // UnUsed 306
    public static <T> Response<T> unUsed(){
        return api(HttpStatus.UnUsed);
    }
    public static <T> Response<T> unUsed(String message){
        return api(message,HttpStatus.UnUsed);
    }
    public static <T> Response<T> unUsed(T object){
        return api(HttpStatus.UnUsed,object);
    }
    public static <T> Response<T> unUsed(String message,T object){
        return api(message,HttpStatus.UnUsed,object);
    }
    // TemporaryRedirect 307
    public static <T> Response<T> temporaryRedirect(){
        return api(HttpStatus.TemporaryRedirect);
    }
    public static <T> Response<T> temporaryRedirect(String message){
        return api(message,HttpStatus.TemporaryRedirect);
    }
    public static <T> Response<T> temporaryRedirect(T object){
        return api(HttpStatus.TemporaryRedirect,object);
    }
    public static <T> Response<T> temporaryRedirect(String message,T object){
        return api(message,HttpStatus.TemporaryRedirect,object);
    }


    /** Errors **/

    // BadRequest
    public static <T> Response<T> badRequest(){
        return api(HttpStatus.BadRequest);
    }
    public static <T> Response<T> badRequest(String message){
        return api(message,HttpStatus.BadRequest);
    }
    public static <T> Response<T> badRequest(T object){
        return api(HttpStatus.BadRequest,object);
    }
    public static <T> Response<T> badRequest(String message,T object){
        return api(message,HttpStatus.BadRequest,object);
    }
    // Unauthorized
    public static <T> Response<T> unauthorized(){
        return api(HttpStatus.Unauthorized);
    }
    public static <T> Response<T> unauthorized(String message){
        return api(message,HttpStatus.Unauthorized);
    }
    public static <T> Response<T> unauthorized(T object){
        return api(HttpStatus.Unauthorized,object);
    }
    public static <T> Response<T> unauthorized(String message,T object){
        return api(message,HttpStatus.Unauthorized,object);
    }
    // PaymentRequired
    public static <T> Response<T> paymentRequired(){
        return api(HttpStatus.PaymentRequired);
    }
    public static <T> Response<T> paymentRequired(String message){
        return api(message,HttpStatus.PaymentRequired);
    }
    public static <T> Response<T> paymentRequired(T object){
        return api(HttpStatus.PaymentRequired,object);
    }
    public static <T> Response<T> paymentRequired(String message,T object){
        return api(message,HttpStatus.PaymentRequired,object);
    }
    // Forbidden
    public static <T> Response<T> forbidden(){
        return api(HttpStatus.Forbidden);
    }
    public static <T> Response<T> forbidden(String message){
        return api(message,HttpStatus.Forbidden);
    }
    public static <T> Response<T> forbidden(T object){
        return api(HttpStatus.Forbidden,object);
    }
    public static <T> Response<T> forbidden(String message,T object){
        return api(message,HttpStatus.Forbidden,object);
    }
    // NotFound
    public static <T> Response<T> notFound(){
        return api(HttpStatus.NotFound);
    }
    public static <T> Response<T> notFound(String message){
        return api(message,HttpStatus.NotFound);
    }
    public static <T> Response<T> notFound(T object){
        return api(HttpStatus.NotFound,object);
    }
    public static <T> Response<T> notFound(String message,T object){
        return api(message,HttpStatus.NotFound,object);
    }
    // MethodNotAllowed
    public static <T> Response<T> methodNotAllowed(){
        return api(HttpStatus.MethodNotAllowed);
    }
    public static <T> Response<T> methodNotAllowed(String message){
        return api(message,HttpStatus.MethodNotAllowed);
    }
    public static <T> Response<T> methodNotAllowed(T object){
        return api(HttpStatus.MethodNotAllowed,object);
    }
    public static <T> Response<T> methodNotAllowed(String message,T object){
        return api(message,HttpStatus.MethodNotAllowed,object);
    }
    // NotAcceptable
    public static <T> Response<T> notAcceptable(){
        return api(HttpStatus.NotAcceptable);
    }
    public static <T> Response<T> notAcceptable(String message){
        return api(message,HttpStatus.NotAcceptable);
    }
    public static <T> Response<T> notAcceptable(T object){
        return api(HttpStatus.NotAcceptable,object);
    }
    public static <T> Response<T> notAcceptable(String message,T object){
        return api(message,HttpStatus.NotAcceptable,object);
    }
    // ProxyAuthenticationRequired
    public static <T> Response<T> proxyAuthenticationRequired(){
        return api(HttpStatus.ProxyAuthenticationRequired);
    }
    public static <T> Response<T> proxyAuthenticationRequired(String message){
        return api(message,HttpStatus.ProxyAuthenticationRequired);
    }
    public static <T> Response<T> proxyAuthenticationRequired(T object){
        return api(HttpStatus.ProxyAuthenticationRequired,object);
    }
    public static <T> Response<T> proxyAuthenticationRequired(String message,T object){
        return api(message,HttpStatus.ProxyAuthenticationRequired,object);
    }
    // RequestTimeout
    public static <T> Response<T> requestTimeout(){
        return api(HttpStatus.RequestTimeout);
    }
    public static <T> Response<T> requestTimeout(String message){
        return api(message,HttpStatus.RequestTimeout);
    }
    public static <T> Response<T> requestTimeout(T object){
        return api(HttpStatus.RequestTimeout,object);
    }
    public static <T> Response<T> requestTimeout(String message,T object){
        return api(message,HttpStatus.RequestTimeout,object);
    }
    // Conflict
    public static <T> Response<T> conflict(){
        return api(HttpStatus.Conflict);
    }
    public static <T> Response<T> conflict(String message){
        return api(message,HttpStatus.Conflict);
    }
    public static <T> Response<T> conflict(T object){
        return api(HttpStatus.Conflict,object);
    }
    public static <T> Response<T> conflict(String message,T object){
        return api(message,HttpStatus.Conflict,object);
    }
    // Gone
    public static <T> Response<T> gone(){
        return api(HttpStatus.Gone);
    }
    public static <T> Response<T> gone(String message){
        return api(message,HttpStatus.Gone);
    }
    public static <T> Response<T> gone(T object){
        return api(HttpStatus.Gone,object);
    }
    public static <T> Response<T> gone(String message,T object){
        return api(message,HttpStatus.Gone,object);
    }
    // LengthRequired
    public static <T> Response<T> lengthRequired(){
        return api(HttpStatus.LengthRequired);
    }
    public static <T> Response<T> lengthRequired(String message){
        return api(message,HttpStatus.LengthRequired);
    }
    public static <T> Response<T> lengthRequired(T object){
        return api(HttpStatus.LengthRequired,object);
    }
    public static <T> Response<T> lengthRequired(String message,T object){
        return api(message,HttpStatus.LengthRequired,object);
    }
    // PreconditionFailed
    public static <T> Response<T> preconditionFailed(){
        return api(HttpStatus.PreconditionFailed);
    }
    public static <T> Response<T> preconditionFailed(String message){
        return api(message,HttpStatus.PreconditionFailed);
    }
    public static <T> Response<T> preconditionFailed(T object){
        return api(HttpStatus.PreconditionFailed,object);
    }
    public static <T> Response<T> preconditionFailed(String message,T object){
        return api(message,HttpStatus.PreconditionFailed,object);
    }
    // RequestEntityTooLarge
    public static <T> Response<T> requestEntityTooLarge(){
        return api(HttpStatus.RequestEntityTooLarge);
    }
    public static <T> Response<T> requestEntityTooLarge(String message){
        return api(message,HttpStatus.RequestEntityTooLarge);
    }
    public static <T> Response<T> requestEntityTooLarge(T object){
        return api(HttpStatus.RequestEntityTooLarge,object);
    }
    public static <T> Response<T> requestEntityTooLarge(String message,T object){
        return api(message,HttpStatus.RequestEntityTooLarge,object);
    }
    // RequestedURITooLong
    public static <T> Response<T> requestedURITooLong(){
        return api(HttpStatus.RequestedURITooLong);
    }
    public static <T> Response<T> requestedURITooLong(String message){
        return api(message,HttpStatus.RequestedURITooLong);
    }
    public static <T> Response<T> requestedURITooLong(T object){
        return api(HttpStatus.RequestedURITooLong,object);
    }
    public static <T> Response<T> requestedURITooLong(String message,T object){
        return api(message,HttpStatus.RequestedURITooLong,object);
    }
    // UnsupportedMediaType
    public static <T> Response<T> unsupportedMediaType(){
        return api(HttpStatus.UnsupportedMediaType);
    }
    public static <T> Response<T> unsupportedMediaType(String message){
        return api(message,HttpStatus.UnsupportedMediaType);
    }
    public static <T> Response<T> unsupportedMediaType(T object){
        return api(HttpStatus.UnsupportedMediaType,object);
    }
    public static <T> Response<T> unsupportedMediaType(String message,T object){
        return api(message,HttpStatus.UnsupportedMediaType,object);
    }
    // RequestRangeNotSatisfiable
    public static <T> Response<T> requestRangeNotSatisfiable(){
        return api(HttpStatus.RequestRangeNotSatisfiable);
    }
    public static <T> Response<T> requestRangeNotSatisfiable(String message){
        return api(message,HttpStatus.RequestRangeNotSatisfiable);
    }
    public static <T> Response<T> requestRangeNotSatisfiable(T object){
        return api(HttpStatus.RequestRangeNotSatisfiable,object);
    }
    public static <T> Response<T> requestRangeNotSatisfiable(String message,T object){
        return api(message,HttpStatus.RequestRangeNotSatisfiable,object);
    }
    // ExpectationFailed
    public static <T> Response<T> expectationFailed(){
        return api(HttpStatus.ExpectationFailed);
    }
    public static <T> Response<T> expectationFailed(String message){
        return api(message,HttpStatus.ExpectationFailed);
    }
    public static <T> Response<T> expectationFailed(T object){
        return api(HttpStatus.ExpectationFailed,object);
    }
    public static <T> Response<T> expectationFailed(String message,T object){
        return api(message,HttpStatus.ExpectationFailed,object);
    }
    // ImATeapot
    public static <T> Response<T> imATeapot(){
        return api(HttpStatus.ImATeapot);
    }
    public static <T> Response<T> imATeapot(String message){
        return api(message,HttpStatus.ImATeapot);
    }
    public static <T> Response<T> imATeapot(T object){
        return api(HttpStatus.ImATeapot,object);
    }
    public static <T> Response<T> imATeapot(String message,T object){
        return api(message,HttpStatus.ImATeapot,object);
    }
    // InternalServerError
    public static <T> Response<T> internalServerError(){
        return api(HttpStatus.InternalServerError);
    }
    public static <T> Response<T> internalServerError(String message){
        return api(message,HttpStatus.InternalServerError);
    }
    public static <T> Response<T> internalServerError(T object){
        return api(HttpStatus.InternalServerError,object);
    }
    public static <T> Response<T> internalServerError(String message,T object){
        return api(message,HttpStatus.InternalServerError,object);
    }
    // NotImplemented
    public static <T> Response<T> notImplemented(){
        return api(HttpStatus.NotImplemented);
    }
    public static <T> Response<T> notImplemented(String message){
        return api(message,HttpStatus.NotImplemented);
    }
    public static <T> Response<T> notImplemented(T object){
        return api(HttpStatus.NotImplemented,object);
    }
    public static <T> Response<T> notImplemented(String message,T object){
        return api(message,HttpStatus.NotImplemented,object);
    }
    // BadGateway
    public static <T> Response<T> badGateway(){
        return api(HttpStatus.BadGateway);
    }
    public static <T> Response<T> badGateway(String message){
        return api(message,HttpStatus.BadGateway);
    }
    public static <T> Response<T> badGateway(T object){
        return api(HttpStatus.BadGateway,object);
    }
    public static <T> Response<T> badGateway(String message,T object){
        return api(message,HttpStatus.BadGateway,object);
    }
    // ServiceUnavailable
    public static <T> Response<T> serviceUnavailable(){
        return api(HttpStatus.ServiceUnavailable);
    }
    public static <T> Response<T> serviceUnavailable(String message){
        return api(message,HttpStatus.ServiceUnavailable);
    }
    public static <T> Response<T> serviceUnavailable(T object){
        return api(HttpStatus.ServiceUnavailable,object);
    }
    public static <T> Response<T> serviceUnavailable(String message,T object){
        return api(message,HttpStatus.ServiceUnavailable,object);
    }
    // GatewayTimeout
    public static <T> Response<T> gatewayTimeout(){
        return api(HttpStatus.GatewayTimeout);
    }
    public static <T> Response<T> gatewayTimeout(String message){
        return api(message,HttpStatus.GatewayTimeout);
    }
    public static <T> Response<T> gatewayTimeout(T object){
        return api(HttpStatus.GatewayTimeout,object);
    }
    public static <T> Response<T> gatewayTimeout(String message,T object){
        return api(message,HttpStatus.GatewayTimeout,object);
    }
    // HttpVersionNotSupported
    public static <T> Response<T> httpVersionNotSupported(){
        return api(HttpStatus.HttpVersionNotSupported);
    }
    public static <T> Response<T> httpVersionNotSupported(String message){
        return api(message,HttpStatus.HttpVersionNotSupported);
    }
    public static <T> Response<T> httpVersionNotSupported(T object){
        return api(HttpStatus.HttpVersionNotSupported,object);
    }
    public static <T> Response<T> httpVersionNotSupported(String message,T object){
        return api(message,HttpStatus.HttpVersionNotSupported,object);
    }
    // Unknown
    public static <T> Response<T> unknown(){
        return api(HttpStatus.Unknown);
    }
    public static <T> Response<T> unknown(String message){
        return api(message,HttpStatus.Unknown);
    }
    public static <T> Response<T> unknown(T object){
        return api(HttpStatus.Unknown,object);
    }
    public static <T> Response<T> unknown(String message,T object){
        return api(message,HttpStatus.Unknown,object);
    }


}




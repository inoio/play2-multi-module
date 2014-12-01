import play.api.GlobalSettings
import play.api.mvc.WithFilters
import io.ino.play.ConcurrentRequestsLimiter

object Global extends GlobalSettings /*WithFilters(ConcurrentRequestsLimiter)*/
package filterorder

class SecondFilters {

    def filters = {
        def dependsOn = [ApiFilters.class]
        all(controller: '*', action: '*') {
            before = {
                log.info(" in second before")
                log.debug(" in second before")
            }
            after = { Map model ->
                log.info("in second after")
                log.debug("in second after")
            }
            afterView = { Exception e ->

            }
        }
        authOne(controller:'*', action:'*') {
            before = {
                log.info("in second before 1")
                log.debug("in second before 1")
            }
            after = {
            }
        }
    }
}

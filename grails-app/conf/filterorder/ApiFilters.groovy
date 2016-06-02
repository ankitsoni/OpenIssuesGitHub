package filterorder

class ApiFilters {

    def filters = {
        all(controller:'*', action:'*') {
            before = {
                log.info("in first before")
                log.debug("in first before")
            }
            after = { Map model ->
                log.info("in first after")
                log.debug("in first after")
            }
            afterView = { Exception e ->

            }
        }
        authOne(controller:'*', action:'*') {
            before = {
                log.info("in first before 1")
                log.debug("in first before 1")
            }
            after = {
            }
        }
    }
}

class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/api/sample"(controller: "sample") {
			action = [GET: "sample"]
		}

		"/"(view:"/index")
		"500"(view:'/error')
	}
}

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

		"/api/zomato"(controller: "google") {
			action = [GET: "zomato"]
		}

		"/"(view:"/index")
		"500"(view:'/error')
	}
}

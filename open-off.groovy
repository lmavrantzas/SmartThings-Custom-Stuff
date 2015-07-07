definition(
    name: "Turn something off when a contact opens",
    namespace: "jaspowell",
    author: "Jas. Powell",
    description: "Turns something off when a contact is opened",
    category: "Convenience",
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png")

preferences {
	section ("When the door opens...") {
		input "contact1", "capability.contactSensor", title: "Where?"
	}
	section ("Turn off a light...") {
		input "switch1", "capability.switch"
	}
}

def installed()
{
	subscribe(contact1, "contact.open", contactOpenHandler)
}

def updated()
{
	unsubscribe()
	subscribe(contact1, "contact.open", contactOpenHandler)
}

def contactOpenHandler(evt) {
	switch1.off()
}

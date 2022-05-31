
const temporaryDetailsCard = 
    `<div class="dog-card-details" style="height: 3rem">
        <img src="/images/index/loading-icon.png" alt="loading..." class="card-loading-details"></img>
    </div>`;

const finalDetailsCard = 
    `<div class="dog-card-details">
        <p>Breed: Labrador Retriever</p>
        <p>Age: 12</p>
        <p>Birthdate: 19-03-2010</p>
    </div>`;

const failDogDetails = {
    content: `<div><p>We're sorry, something went wrong!</p><p>Try again later.</p></div>`,
    height: "4rem"
}

const MAX_DETAILS_LINE_LENGTH = 30;


function show_dogs_details(card) {
    card.innerHTML += temporaryDetailsCard;
    let id = card.id;

    fetch('http://localhost:8080/api/v1/dogs/' + id)
        .then(response => {
            if (response.ok) {
                return response.json();
            }
        })
        .then(response => {
//            console.log(response);
            if (!response) {
                load_concrete_dog_details(card, failDogDetails);
                return;
            }

            let detailsHeight = 2;
            let responseContent = "<div>";
            for (let attr in response) {
//                console.log(attr + ": " + response[attr]);
                if (response[attr] != null) {
                    if (attr == "imageSource" || attr == "id") {
                        continue;
                    }

                    let capitalAttr = attr[0].toUpperCase() + attr.slice(1);
                    let restLength = MAX_DETAILS_LINE_LENGTH - attr.length - 2;
                    let attrValue = restLength < response[attr].length ? response[attr].slice(0,restLength-3) + "..." : response[attr];
                    // console.log(attrValue);
                    responseContent += "<p><b>" + capitalAttr + ": </b>" + attrValue + "</p>\n";
                    detailsHeight += 1.2;
                }
            }
            responseContent += "</div>";

            details = {
                height: detailsHeight + "rem",
                content: responseContent
            }

//            console.log(responseContent);
            load_concrete_dog_details(card, details);
        })
        .catch(error => {
            console.error(error);
        });
}

function load_concrete_dog_details(card, details) {

    card.lastChild.style.height = details.height;
    card.lastChild.innerHTML = details.content;
}

function hide_dogs_details(card) {
    card.removeChild(card.lastChild);
}
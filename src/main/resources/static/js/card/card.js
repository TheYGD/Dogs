
let pathnameArray = window.location.pathname.split("/");
let cardId = pathnameArray[pathnameArray.length - 1];

let dog;

fetch('http://localhost:8080/api/v1/dogs/' + cardId)
    .then(response => {
        if (response.ok) {
            return response.json();
        }
    })
    .then(response => {
        console.log(response);
        dog = response;
        
        let cardDetails = document.getElementsByClassName("card-details")[0];
        cardDetails.children[0].innerHTML += dog.name;
        cardDetails.children[1].innerHTML += dog.breed;

        let age = Math.floor((new Date() - new Date(dog.birthDate)) / 31536000000);
        // let age = new Date().getYear() - new Date(dog.birthDate).getYear();
        cardDetails.children[2].innerHTML += age;

        cardDetails.children[3].innerHTML += dog.birthDate;
        cardDetails.children[4].innerHTML += dog.motherId;
        cardDetails.children[5].innerHTML += dog.fatherId;
        cardDetails.children[6].innerHTML += dog.ownerUsername;
    });

    let editButtonA = document.getElementById('btn-edit');
    editButtonA.href = '/cards/edit/' + cardId;

    let removeButton = document.getElementById('btn-remove');
    removeButton.addEventListener("click", () => {
        var xhr = new XMLHttpRequest();
        xhr.open('DELETE', '/api/v1/dogs/' + cardId);

        xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            alert('Usunieto psa o id ' + cardId);
            window.location.href = "/";
        }};

        xhr.send();

    });


    // <div class="card-details">
    //             <p><b>Name: </b></p>
    //             <p><b>Breed: </b></p>
    //             <p><b>Age: </b></p>
    //             <p><b>BirthDate: </b></p>
    //             <p><b>Mother: </b></p>
    //             <p><b>Father: </b></p>
    //             <p><b>Owner: </b></p>
    //         </div>


const dogsContainer = document.getElementById("dogs-container");

const defaultDogIcon = `<svg>
                                        <g transform="translate(-61.171 36.982)">
                                          <g>
                                           <path d="m243.83 28.983c0.4064-21.618 9.4157-44.069-16.833-63.108-5.0568-3.3923-24.727 17.818-30.159 26.048 15.673 12.353 33.959 24.707 46.991 37.06z" fill="#eeb75a" stroke="#4f3d30" stroke-linecap="square" stroke-linejoin="round" stroke-width="4.9901"/>
                                           <path d="m235.36 23.879c0.2874-15.303 7.5244-32.742-11.056-46.219-3.1426-2.8383-18.363 14.16-22.208 19.985 11.095 8.7445 24.039 17.489 33.264 26.234z" fill="#eee8c8"/>
                                           <path d="m103.79 28.983c-0.40637-21.618-9.4157-44.069 16.833-63.108 5.0568-3.3923 24.727 17.818 30.159 26.048-15.673 12.353-33.959 24.707-46.991 37.06z" fill="#eeb75a" stroke="#4f3d30" stroke-linecap="square" stroke-linejoin="round" stroke-width="4.9901"/>
                                           <path d="m112.25 23.879c-0.2874-15.303-7.5245-32.742 11.056-46.219 3.1426-2.8383 18.363 14.16 22.208 19.985-11.095 8.7445-24.039 17.489-33.264 26.234z" fill="#eee8c8"/>
                                           <path d="m173.33-10.601c-67.599 3.6675-72.522 38.357-73.638 71.231-1.5474 45.587 58.03 50.455 73.638 50.149 0.0724-2e-3 0.14232-7e-3 0.21434-7e-3v2e-3c0.0719 0 0.142 7e-3 0.21436 7e-3 15.607 0.30524 75.185-4.5622 73.638-50.149-1.1159-32.874-6.0388-67.563-73.638-71.231-0.14439-0.02058-0.29666-0.0013-0.4287-0.0018z" fill="#eeb75a" stroke="#502d16" stroke-linecap="square" stroke-linejoin="round" stroke-width="4.9901"/>
                                           <circle cx="135.31" cy="58.784" r="8.1351" fill="#4f3d30"/>
                                           <circle cx="212.88" cy="58.784" r="8.1351" fill="#4f3d30"/>
                                           <path d="m173.55 47.259c-28.473 0.4723-16.153 24.693-31.166 29.442-11.57 2.3432-27.477 0.5901-34.145 7.5624 8.6278 20.877 37.126 27.589 65.311 26.266 28.185 1.3232 56.683-5.389 65.311-26.266-6.6681-6.9724-22.576-5.2193-34.145-7.5624-15.013-4.7488-2.6931-28.969-31.166-29.442z" fill="#eee8c8"/>
                                          </g>
                                          <path d="m173.33-10.845c-67.599 3.6675-72.522 38.357-73.638 71.231-1.5474 45.587 58.03 50.455 73.638 50.149 0.0724-2e-3 0.14232-7e-3 0.21434-7e-3v2e-3c0.0719 0 0.142 7e-3 0.21436 7e-3 15.607 0.30524 75.185-4.5623 73.638-50.149-1.1159-32.874-6.0388-67.563-73.638-71.231-0.14439-0.02058-0.29666-0.0013-0.4287-0.0018z" fill="none" stroke="#4f3d30" stroke-linecap="square" stroke-linejoin="round" stroke-width="4.9901"/>
                                          <ellipse cx="173.7" cy="62.32" rx="6.1501" ry="4.631" fill="#483e37"/>
                                          <path d="m162.33 72.37c6.9092 9.3361 11.377-3.592 11.221-9.9654" fill="none" stroke="#4f3d30" stroke-linecap="round" stroke-width="3.9955"/>
                                          <path d="m184.77 72.37c-6.9093 9.3361-11.377-3.592-11.221-9.9654" fill="none" stroke="#4f3d30" stroke-linecap="round" stroke-width="3.9955"/>
                                          <rect transform="rotate(-15)" x="113.02" y="65.062" width="15.827" height="9.4457" rx="3.9568" ry="4.7228" fill="#eee8c8"/>
                                          <rect transform="matrix(-.96593 -.25882 -.25882 .96593 0 0)" x="-223.34" y="-25.257" width="15.827" height="9.4457" rx="3.9568" ry="4.7228" fill="#eee8c8"/>
                                         </g>
                                    </svg>`;

const MAX_NAME_LINE_LENGTH = 10;


fetch('http://localhost:8080/api/v1/dogs/names')
    .then(response => response.json())
    .then(response => {
        console.log(response);
        for (let dogBasics of response) {
            let divWithImage;
            if (dogBasics.imageSource.startsWith("//")) {
                let backgroundColor = "hsl(" +  dogBasics.imageSource.slice(2) + ", 80%, 80%)";
                divWithImage = `<div style="background-color: ${backgroundColor}" class="dog-card-img-container">${defaultDogIcon}</div>`;
            }
            else {
                divWithImage = `<div class="dog-card-img-container"><img src="${dogNameAndImg.imageSource}" alt="picture of a dog"></img></div>`;
            }

            let displayedName = dogBasics.name.length > MAX_NAME_LINE_LENGTH ? dogBasics.name.slice(0, MAX_NAME_LINE_LENGTH-3) + "..." : dogBasics.name;

            dogsContainer.innerHTML +=
            `<div onmouseenter="show_dogs_details(this)" onmouseout="hide_dogs_details(this)" onclick="location.href = '/cards/${dogBasics.id}';" class="dog-card" id="${dogBasics.id}">
                ${divWithImage}
                <p class="dog-card-name">${displayedName}</p>
            </div>`;
        }
    });
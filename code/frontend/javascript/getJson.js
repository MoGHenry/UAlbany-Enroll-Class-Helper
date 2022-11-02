//  https://webapi20221031145639.azurewebsites.net/api/todoitems

fetch('https://webapi20221031145639.azurewebsites.net/api/todoitems')
    .then((response) => response.json())
    .then((data) => console.log(data));

// https://requirejs.org/docs/release/2.3.5/minified/require.js

// function getJson(url) {
// const url = 'https://webapi20221031145639.azurewebsites.net/api/todoitems';
// const https = require('https');
//
// const request = https.get(url, (response) => {
//     let data = '';
//     response.on('data', (chunk) => {
//         data += chunk.toString();
//     });
//
//     response.on('end', () => {
//         const body = JSON.parse(data);
//         console.log(body);
//     });
// })
//
// request.on('error', (error) => {
//     console.log('An error', error);
// });
//
// request.end()

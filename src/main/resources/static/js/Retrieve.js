function loadModal(pevId){

 console.log("Loading modal for ID:", pevId);

   fetch(`/retrievepevent/${pevId}`)
   .then(response=> response.json())
   .then(data => {
   document.querySelector('#updateModal [name="peId"]')
   .value=data.peId;
   document.querySelector('#updateModal [name="peDm"]')
      .value=data.peDm;
   document.querySelector('#updateModal [name="peYear"]')
      .value=data.peYear;
   document.querySelector('#updateModal [name="peTitle"]').value=data.peTitle;
   document.querySelector('#updateModal [name="peDesc"]')
   .value=data.peDesc;

   })
   .catch(error=>console.error('Error fetching event data:',
   error));
}
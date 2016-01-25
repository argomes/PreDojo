  window.onload = function() {
                var dropbox = document.getElementById("dropbox");
                dropbox.addEventListener("dragenter", noop, false);
                dropbox.addEventListener("dragexit", noop, false);
                dropbox.addEventListener("dragover", noop, false);
                dropbox.addEventListener("drop", dropUpload, false);
            }

            function noop(event) {
                event.stopPropagation();
                event.preventDefault();
            }

            function dropUpload(event) {
                noop(event);
                var files = event.dataTransfer.files;

                for (var i = 0; i < files.length; i++) {
                    upload(files[i]);
                }
            }

            function upload(file) {
                document.getElementById("status").innerHTML = "Uploading " + file.name;

                var formData = new FormData();
                formData.append("file", file);
                formData.append("parentDocumentId","TesteparentDocumentId");
                formData.append("pastaDestino","TESTEpastaDestino");
                formData.append("documentDescription","TESTEdocumentDescription");
                formData.append("nomeDocumento","TESTEnomeDocumento");
                var xhr = new XMLHttpRequest();
                xhr.upload.addEventListener("progress", uploadProgress, false);
                xhr.addEventListener("load", uploadComplete, false);
                xhr.open("POST", "InputControl", true); // If async=false, then you'll miss progress bar support.
                xhr.send(formData);
            }

            function uploadProgress(event) {
                // Note: doesn't work with async=false.
                var progress = Math.round(event.loaded / event.total * 100);
                document.getElementById("status").innerHTML = "Progress " + progress + "%";
            }

            function uploadComplete(event) {
                drawTable(JSON.parse(event.target.responseText));
                
            }
            function drawTable(data) {
                for (var i = 0; i < data.length; i++) {
                    drawRow(data[i]);
                }
            }
            function drawRow(rowData) {
                var row = "<tr>";
               
                row +="<td>" + rowData.usuario + "</td>";
                row +="<td>" + rowData.qntMortes + "</td>";
                row +="<td>" + rowData.qntassassinatos + "</td>";
                row +="<td>" + rowData.idPartida + "</td></tr>";
                $("#personDataTable").append(row);
            }
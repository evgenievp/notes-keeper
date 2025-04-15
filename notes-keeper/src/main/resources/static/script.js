const API_URL = "http://localhost:8080/api/notes";

document.getElementById("note-form").addEventListener("submit", async function (e) {
  e.preventDefault();

  const title = document.getElementById("title").value;
  const content = document.getElementById("content").value;

  const response = await fetch(API_URL, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ title, content })
  });

  if (response.ok) {
    alert("Note added!");
    loadNotes();
  } else {
    alert("Error adding note.");
  }
});

async function loadNotes() {
  const res = await fetch(API_URL);
  const notes = await res.json();

  const list = document.getElementById("note-list");
  list.innerHTML = "";

  notes.forEach(note => {
    const li = document.createElement("li");
    li.innerText = `${note.title}: ${note.content}`;
    list.appendChild(li);
  });
}

async function searchNotes() {
  const keyword = document.getElementById("search").value;
  const res = await fetch(`${API_URL}/search?keyword=${keyword}`);
  const results = await res.json();

  const list = document.getElementById("note-list");
  list.innerHTML = "";

  results.forEach(note => {
    const li = document.createElement("li");
    li.innerText = `${note.title}: ${note.content}`;
    list.appendChild(li);
  });
}

loadNotes();

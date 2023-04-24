let sentences = []
function generate(){
var rules = {
    "origin": ["#sentence.capitalize#"],
    "sentence": ["Why don't scientists trust atoms? Because they #pun#.", "I told my wife she was drawing her eyebrows too high. She looked #adverb# surprised.", "Why did the tomato turn red? Because it saw the #object#.", "Why did the chicken join a band? Because it already had #object#!"],
    "pun": ["make up everything", "have no vision", "fall for anything"],
    "adverb": ["shocked", "surprised", "astonished"],
    "object": ["ketchup", "salad", "frying pan", "drumsticks"]
  }


let grammar = tracery.createGrammar(rules);

let expansion = grammar.flatten('#origin#');

sentences.push(expansion);
printSentences(sentences);
}

function printSentences(sentences) {
    let textBox = document.getElementById("sentences");
    textBox.innerHTML = "";
    for(let i=sentences.length-1; i>=0; i--) {
        textBox.innerHTML += "<p>"+sentences[i]+"</p>"
    }



}


/*"Why did the chicken join a band? Because it already had drumsticks!",
    "Why don't seagulls fly by the bay? Because then they would be bay-gulls!",
    "Why did the belt go to jail? For holding up pants!",
    "I'm reading a book about anti-gravity. It's impossible to put down!",
    "What did the left eye say to the right eye? 'Between us, something smells!'",
    "What did the janitor say when he jumped out of the closet? 'Supplies!'",
    "Why did the cookie go to the doctor? Because it was feeling crumbly!",
    "Why don't ghosts use elevators? Because they lift their own spirits!",
    "What did the grape say when it got stepped on? 'Nothing, it just let out a little wine!'"
    */

import nltk
import string
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.metrics.pairwise import cosine_similarity
from nltk.corpus import stopwords
# nltk.download('punkt')
# # Download NLTK stop words (if not already downloaded)
# nltk.download('stopwords')

# Sample documents (replace with your database)
documents = [
    "Original research is fundamental for scientific progress. It is the cornerstone of knowledge advancement and discovery. The process of conducting research involves systematic investigation and analysis of data.",
    "This document is the second document.",
    "Original research is essential for scientific progress. It is the foundation of knowledge advancement and exploration. The procedure of performing research involves systematic inquiry and examination of data.",
    "Is this the first document?",
]

# Function to preprocess and tokenize a document
def preprocess(document):
    # Convert to lowercase
    document = document.lower()
    
    # Tokenization based on words
    tokens = nltk.word_tokenize(document)
    
    # Remove punctuation and stop words
    tokens = [word for word in tokens if word not in string.punctuation]
    tokens = [word for word in tokens if word not in stopwords.words('english')]
    
    # Join tokens back into a string
    preprocessed_document = ' '.join(tokens)
    
    return preprocessed_document

# Preprocess and tokenize all documents
preprocessed_documents = [preprocess(doc) for doc in documents]
print(preprocessed_documents)
# TF-IDF Vectorization
tfidf_vectorizer = TfidfVectorizer()
tfidf_matrix = tfidf_vectorizer.fit_transform(preprocessed_documents)
# print(tfidf_matrix.toarray())
# Calculate cosine similarity
cosine_similarities = cosine_similarity(tfidf_matrix, tfidf_matrix)
print(cosine_similarities)
# Set a threshold for plagiarism detection (adjust as needed)
threshold = 0.30

# Detect plagiarism
for i in range(len(cosine_similarities)):
    for j in range(i+1, len(cosine_similarities)):
        similarity = cosine_similarities[i][j]
        if similarity > threshold:
            print(f"Plagiarism Detected between Document {i+1} and Document {j+1} (Similarity: {similarity:.2f})")

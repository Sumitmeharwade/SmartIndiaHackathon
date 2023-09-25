import pandas as pd
import numpy as np
from nltk.corpus import stopwords
import nltk
nltk.download('stopwords')
import re
from sklearn.feature_extraction.text import TfidfVectorizer 
from sklearn.metrics.pairwise import cosine_similarity
from sentence_transformers import SentenceTransformer
sbert_model = SentenceTransformer('bert-base-nli-mean-tokens')



def most_similar(doc_id,similarity_matrix,matrix,documents_df):

    print ('Similar Documents:')
    result_list = []
    if matrix=='Cosine Similarity':
        similar_ix=np.argsort(similarity_matrix[doc_id])[::-1]
    elif matrix=='Euclidean Distance':
        similar_ix=np.argsort(similarity_matrix[doc_id])
    for ix in similar_ix:
        if ix==doc_id:
            continue
        document_info = {
        "Document": documents_df.iloc[ix]["documents"],
        "Similarity": similarity_matrix[doc_id][ix]
        }
        result_list.append(document_info)
        
        return result_list




def check(documents):
    documents_df=pd.DataFrame(documents,columns=['documents'])
    stop_words_l=stopwords.words('english')
    documents_df['documents_cleaned']=documents_df.documents.apply(lambda x: " ".join(re.sub(r'[^a-zA-Z]',' ',w).lower() for w in x.split() if re.sub(r'[^a-zA-Z]',' ',w).lower() not in stop_words_l) )
    document_embeddings = sbert_model.encode(documents_df['documents_cleaned'])
    pairwise_similarities=cosine_similarity(document_embeddings)
    return(most_similar(0,pairwise_similarities,'Cosine Similarity',documents_df))
documents = ["I was sleeping in my room when I heard a loud noise",
'Machine learning is closely related to computational statistics, which focuses on making predictions using computers.\
The study of mathematical optimization delivers methods, theory and application domains to the field of machine learning.',
'Machine learning involves computers discovering how they can perform tasks without being explicitly programmed to do so. \
It involves computers learning from data provided so that they carry out certain tasks.',
'Machine learning approaches are traditionally divided into three broad categories, depending on the nature of the "signal"\
or "feedback" available to the learning system: Supervised, Unsupervised and Reinforcement',
'Neural networks are artificial systems that were inspired by biological neural networks. These systems learn to perform tasks by being exposed to various datasets and examples without any task-specific rules. The idea is that the system generates identifying characteristics from the data they have been passed without being programmed with a pre-programmed understanding of these datasets. Neural networks are based on computational models for threshold logic.',
"While peacefully resting in my bedroom, I suddenly became aware of a resounding disturbance."
]
# print(check(documents))
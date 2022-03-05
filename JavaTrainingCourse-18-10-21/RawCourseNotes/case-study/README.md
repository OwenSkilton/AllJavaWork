# The Movie App Case Study

## Part 1

As it stands the Service is tightly coupled to the Repo. Make the necessary changes so that
the coupling is loose. This may involve coding new classes.

Optionally you might like to add some more findBy methods in the Service, e.g. 
findByGenre, findByReleaseYear, findByClassification.

## Part 2

Code a MovieReview class. Each review should have a movie, reviewer, date, text, and rating (0-5 stars). 
You will have to decide what type of assoc. exists between MovieReview and Movie. Note that HAS-A associations
can be bi-directional however such associations are tricky to manage and are often not worth the trouble. 

## Part 3

Business rules dictate that the app should not accept duplicate Movies. Modify the service such that if the user
adds a duplicate Movie an appropriate exception will be thrown. The service need not know what constitutes a 
duplicate Movie - that information should be built-in to the Movie class.

Code a test to verify that the service will not accept duplicate Movies.

## Part 4

There are two opportunities to exploit enums in the case study - Movie genre and MovieReview rating. The rating
is likely to be used to calculate an average rating for each Movie and requires seven values - NOT_RATED, 
ZERO_STARS, ONE_STAR, TWO_STARS etc. You might have to add a field to the enum to enable the calculation of the 
average rating.

## Part 5

We needn't have many instances of the service or the repo - make them singletons. Once a Movie is released it 
does not change - make Movies immutable.

Is it possible to modify the Movie class so that new Movies can be created from existing ones without breaking
the Movie's immutability?

## Part 6

Make it so that Movies have a natural sort order - by genre, then by release year, 
then by title. Write a test to verify the natural sort order.

Optionally you should modify your service such that the findBy methods returns Movies sorted.

## Part 7

Update your findBy methods in the service to exploit streams and lambdas. Note that the 
service should have methods including:

- findByPartialTitle
- findByGenre
- findByReleaseYearInRange
- findByClassification

What are the service's shortcomings in terms of searching Movies and how might these 
be overcome using these tools?

## Part 8

Write two tests for MovieUtils::fetchMovie:

1. Iterate over the imdbIDs List and fetch each movie sequentially. You should time it and write the total time
to stdout.
   
2. Do as per the first test but exploit threads and see if threading improves the performance.
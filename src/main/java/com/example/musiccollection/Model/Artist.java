    package com.example.musiccollection.Model;

    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.Id;
    import jakarta.persistence.ManyToOne;


    public class Artist
    {
        @Id
        @GeneratedValue
        private int artistId; // Unique identifier for the artist


        private String name;

        @ManyToOne
        private Address address; // Relationship with Address

        public Artist()
        {}


        public Artist(String name, Address address)
        {
            this.name = name;
            this.address = address;
        }


        public int getArtistId()
        {
            return artistId;
        }

        public String getName()
        {
            return name;
        }

        public Address getAddress()
        {
            return address;
        }

        public void setArtistId(int artistId)
        {
            this.artistId = artistId;
        }

        public void setName(String name)
        {
            this.name = name;
        }

        public void setAddress(Address address)
        {
            this.address = address;
        }
    }


package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
    @Test
    void testCheckIn_shouldOccupyAndDirtyRoom() {


        // Arrange: The room is initially not occupied and not dirty
        assertFalse(room.isOccupied());
        assertFalse(room.isDirty());

        // Act: Check in the room
        room.checkIn();

        // Assert: The room is now occupied and dirty
        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    void testCheckOut_shouldMakeRoomNotOccupied() {
        // Arrange: The room is occupied
        room.setOccupied(true);

        // Act: Check out the room
        room.checkOut();

        // Assert: The room is no longer occupied
        assertFalse(room.isOccupied());
    }

    @Test
    void testCleanRoom_shouldMakeRoomNotDirty_whenRoomIsNotOccupiedAndIsDirty() {
        // Arrange: The room is not occupied and is dirty
        room.setOccupied(false);
        room.setDirty(true);

        // Act: Clean the room
        room.cleanRoom();

        // Assert: The room is no longer dirty
        assertFalse(room.isDirty());
    }

    @Test
    void testCleanRoom_whenRoomIsNotOccupiedAndIsNotDirty_shouldNotChangeState() {
        // Arrange: The room is not occupied and is not dirty
        room.setOccupied(false);
        room.setDirty(false);

        // Act:  Clean the room
        room.cleanRoom();

        // Assert: The room remains not dirty
        assertFalse(room.isDirty());
    }

    @Test
    void testCleanRoom_whenRoomIsOccupied_shouldNotChangeState() {
        // Arrange: The room is occupied and dirty
        room.setOccupied(true);
        room.setDirty(true);

        // Act: Clean the room
        room.cleanRoom();

        // Assert: The room remains dirty
        assertTrue(room.isDirty());
    }


}
#pragma once

#include "../tracker/impl/action_tracker.h"
#include "../tracker/impl/collision_tracker.h"
#include "../tracker/impl/movement_tracker.h"

class TrackerProvider {

public:

    virtual auto getActionTracker() -> ActionTracker* = 0;

    virtual auto getCollisionTracker() -> CollisionTracker* = 0;

    virtual auto getMovementTracker() -> MovementTracker* = 0;

};